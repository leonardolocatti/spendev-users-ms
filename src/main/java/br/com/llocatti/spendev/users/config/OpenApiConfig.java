package br.com.llocatti.spendev.users.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
    info =
        @Info(
            title = "Spendev Users Microservice",
            version = "0.1.0-SNAPSHOT",
            description = "Spendev users microservice documentation",
            license = @License(name = "MIT License"),
            contact =
                @Contact(
                    name = "Leonardo Locatti",
                    url = "https://www.llocatti.com.br/",
                    email = "contato@llocatti.com.br")),
    externalDocs =
        @ExternalDocumentation(
            description = "GitGub repository",
            url = "https://github.com/leonardolocatti/spendev-users-ms"))
public class OpenApiConfig {}
