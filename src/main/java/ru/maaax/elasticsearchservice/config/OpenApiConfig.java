package ru.maaax.elasticsearchservice.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger configuration
 */
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)

@Configuration
public class OpenApiConfig {

    @Value("${app.url}")
    private String appUrl;

    @Bean
    public OpenAPI elasticSearchOpenAPI() {
        final Server server = new Server().url(appUrl);

        final OpenAPI openAPI = new OpenAPI()
                .info(new Info().title("Elastic Search API")
                        .description("Elastic-Search application")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
        openAPI.setServers(List.of(server));
        return openAPI;
    }
}
