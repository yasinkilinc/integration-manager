package tr.com.atez.integration.manager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.config.BusinessConfig;
import tr.com.atez.integration.manager.dto.BeyannameStatus;
import tr.com.atez.integration.manager.entity.Manifesto;
import tr.com.atez.integration.manager.util.FileUtils;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ManifestoSenderService {

    private final ManifestoService manifestoService;
    private final EmailService emailService;
    private final BusinessConfig businessConfig;

    public ManifestoSenderService(ManifestoService manifestoService, EmailService emailService, BusinessConfig businessConfig) {
        this.manifestoService = manifestoService;
        this.emailService = emailService;
        this.businessConfig = businessConfig;
    }

    @Scheduled(fixedDelayString = "${app.business.fixedDelayString}")
    public void execute() {
        List<Manifesto> manifestoList = manifestoService.findByStatusOrderByCreateDate(Manifesto.Status.PROCESSING);
        manifestoList.forEach( manifesto -> {
            HashMap<String, BeyannameStatus> isPoNumberExistsInDb = new HashMap<>();
            File mailFile = null;
            try {
                mailFile = new File(manifesto.getFilePath());
                InputStream file = FileUtils.fileToInputStream(manifesto.getFilePath());

                HashMap<String, List<String>> malzemeKodMap = new HashMap<>();
                manifestoService.processFile(file, isPoNumberExistsInDb, malzemeKodMap);

                manifestoService.save(manifesto, Manifesto.Status.SUCCESSFUL);

                String successfulMailContent = getPoNumbersTable(isPoNumberExistsInDb, malzemeKodMap);

                log.info("File processed: {}", manifesto.getFilePath());

                emailService.sendEmail(mailFile, successfulMailContent, businessConfig.getMailToSuccess());

            } catch (Exception ex) {
                log.error("File Error: ",ex);
                manifestoService.save(manifesto, Manifesto.Status.FAILED);

                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));

                String failMailContent = createFailMailContent(manifesto, isPoNumberExistsInDb, errors);

                emailService.sendEmail(mailFile,  failMailContent, businessConfig.getMailToFail());
            }
        });
        if(manifestoList.size() > 0){
            System.gc();
        }
    }

    private String createFailMailContent(Manifesto row, HashMap<String, BeyannameStatus> isPoNumberExistsInDb, StringWriter errors) {

        List<String> poNumbers = isPoNumberExistsInDb.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("PO Numbers:").append(poNumbers)
        .append("<br>")
        .append("Error: ").append(row)
        .append("<br>")
        .append("Stack Trace: ").append(errors);
        return sb.toString();
    }

    private String getPoNumbersTable(HashMap<String, BeyannameStatus> isPoNumberExistsInDb, HashMap<String, List<String>> malzemeKodMap) {
        final StringBuilder poNumberstable = new StringBuilder("<table border='1'>");
        if(isPoNumberExistsInDb.size() > 0){

            poNumberstable.append("<tr><td>PO#</td><td>ReferansNo</td><td>Durum</td><td>Eşleşemeyen Malzeme Kodları ( ASIN )</td></tr>");
            isPoNumberExistsInDb.entrySet().stream().forEach(entry -> {
                BeyannameStatus beyannameStatus = entry.getValue();
                    
                    log.info("beyannameStatus: {}", beyannameStatus);

                    poNumberstable.append("<tr align='center'><td>")
                            .append(entry.getKey())
                            .append("</td><td>")
                            .append(beyannameStatus.getBeyanname().getReferansNo())
                            .append("</td><td>")
                            .append(beyannameStatus.isStatus() ? "Mevcut": "Yeni")
                            .append("</td>");
                    if(malzemeKodMap.containsKey(entry.getKey())){
                        String asins = getMalzemeKodToString(malzemeKodMap.get(entry.getKey()));
                        poNumberstable.append("<td>").append(asins).append("</td>");
                    }else{
                        poNumberstable.append("<td>").append("</td>");
                    }

            });
        }
        return poNumberstable + "</table>";
    }
    private String getMalzemeKodToString(List<String> malzemeKodList) {
        String malzemeKodString = "";
        if(malzemeKodList.size() > 0){
            malzemeKodString = malzemeKodList.stream().collect(Collectors.joining(" | "));
        }
        return malzemeKodString;
    }

}
