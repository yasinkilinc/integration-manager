package tr.com.atez.integration.manager.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.business")
public class BusinessConfig {

    private String firmaKod;
    private String kullaniciKod;
    private String departmanId;
    private String etdTarihi;
    private String tahminiVarisTarihi;
    private String savePath;
    private String mailFrom;
    private String mailToSuccess;
    private String mailToFail;
    private String mailSubject;
    private String beyannameKullaniciKod;

    @Value("${spring.profiles.active}")
    private String activeProfile;

}
