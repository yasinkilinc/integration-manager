package tr.com.atez.integration.manager.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiConfig {

    @Bean
    public OpenAPI orderOpenAPI(
            @Value("${openapi.app.description}") String description,
            @Value("${openapi.app.version}") String version,
            @Value("${openapi.app.title}") String title,
            @Value("${openapi.app.contact}") String contactName,
            @Value("${openapi.app.email}") String email,
            @Value("${openapi.app.licence}") String licenseName,
            @Value("${openapi.app.url}") String url
    ) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title(title).description(description).version(version)
                        .contact(new Contact().name(contactName).email(email))
                        .license(new License().name(licenseName).url(url))
                );

    }
}