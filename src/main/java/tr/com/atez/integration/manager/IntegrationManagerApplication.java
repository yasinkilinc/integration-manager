package tr.com.atez.integration.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IntegrationManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationManagerApplication.class, args);
    }
}
