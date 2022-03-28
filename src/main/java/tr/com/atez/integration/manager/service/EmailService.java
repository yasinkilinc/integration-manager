package tr.com.atez.integration.manager.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tr.com.atez.integration.manager.config.BusinessConfig;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Slf4j
@Service
public class EmailService {
    private final JavaMailSender emailSender;
    private final BusinessConfig businessConfig;

    public EmailService(JavaMailSender emailSender, BusinessConfig businessConfig) {
        this.emailSender = emailSender;
        this.businessConfig = businessConfig;
    }

    public void sendEmail(File file, String content, String to) {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(businessConfig.getMailFrom());
            helper.setTo(InternetAddress.parse(to));
            helper.setSubject(businessConfig.getMailSubject() + " -- "+ businessConfig.getActiveProfile());
            helper.setText(content, true);
            if (null != file && file.exists() && !file.isDirectory()) {
                helper.addAttachment(file.getName(), file);
            }
        } catch (Exception ex) {
            log.error("Mail send error: {}", ex);
        }
        emailSender.send(message);
        log.info("Mail sent --> filename: {}", file != null ? file.getName(): "" );
    }
}