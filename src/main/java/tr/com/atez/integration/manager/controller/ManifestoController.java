package tr.com.atez.integration.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.com.atez.integration.manager.config.BusinessConfig;
import tr.com.atez.integration.manager.dto.ManifestoRequestDTO;
import tr.com.atez.integration.manager.entity.Manifesto;
import tr.com.atez.integration.manager.exception.AppException;
import tr.com.atez.integration.manager.exception.ErrorCodes;
import tr.com.atez.integration.manager.service.ManifestoService;
import tr.com.atez.integration.manager.util.FileUtils;

import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;

import static tr.com.atez.integration.manager.constant.ControllerMappingConstants.MANIFESTO_CONTROLLER;

@Slf4j
@RestController
public class ManifestoController {

    private final ManifestoService manifestoService;
    private final BusinessConfig businessConfig;

    public ManifestoController(ManifestoService manifestoService, BusinessConfig businessConfig) {
        this.manifestoService = manifestoService;
        this.businessConfig = businessConfig;
    }

    @RequestMapping(value = MANIFESTO_CONTROLLER, method = RequestMethod.POST)
    public ResponseEntity<String> createManifesto(@Valid @RequestBody ManifestoRequestDTO manifestoRequest){
        log.info("Received Encoded File ");
        try{
            InputStream inputStream = FileUtils.base64ToInputStream(manifestoRequest.getBase64Excel());
            String savePath = businessConfig.getSavePath().isEmpty()? null: businessConfig.getSavePath();
            String fileName = manifestoRequest.getFileName();
            File file = FileUtils.saveFS(inputStream, savePath, fileName);

            Manifesto manifestoEntity = new Manifesto();
            manifestoEntity.setRetry(-1);
            manifestoEntity.setFilePath(file.getPath());
            manifestoEntity.setFileName(fileName);
            manifestoService.save(manifestoEntity);

            log.info( "{}" ,manifestoEntity);
        } catch (Exception e) {
            throw new AppException(ErrorCodes.SYSTEM_FAILURE, e);
        }
        return ResponseEntity.ok().body("OK");
    }
}
