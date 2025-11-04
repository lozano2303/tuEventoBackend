package com.capysoft.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//configuración de Swagger para la documentación de la API de tu evento
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                .title("Tu Evento API")
                .version("2.0")
                .description("Documentación de la API para la gestión de Tu Evento."));
    }

}
