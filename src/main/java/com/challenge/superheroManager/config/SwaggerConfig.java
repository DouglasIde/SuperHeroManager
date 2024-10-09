package com.challenge.superheroManager.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI springSuperheroOpenAPI(){
        return new OpenAPI()
            .info(new Info()
                    .title("Superhero Manager")
                    .description("Superhero Manager API for the Alura' 7-days-to-code challenge")
                    .version("v0.0.1")
                    .license(new License()
                            .name("Douglas Yugo")
                            .url("https://www.linkedin.com/in/douglas-yugo/"))
                    .contact(new Contact()
                            .name("Douglas Yugo")
                            .url("https://linktr.ee/DouglasYugo")
                            .email("douglasymide@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                    .description("Superhero Manager Documentation")
                    .url("https://github.com/DouglasIde"));
    }


}
