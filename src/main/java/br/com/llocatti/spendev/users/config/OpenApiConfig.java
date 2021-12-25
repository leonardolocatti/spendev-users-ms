package br.com.llocatti.spendev.users.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
    info =
        @Info(
            title = "Spendev Users Microservice",
            version = "0.1.0-SNAPSHOT",
            description = "Spendev users microservice documentation",
            contact =
                @Contact(
                    name = "Leonardo Locatti",
                    url = "https://www.llocatti.com.br/",
                    email = "contato@llocatti.com.br")))
public class OpenApiConfig {

  //  @Bean
  //  public OpenAPI openAPI() {
  //    return new OpenAPI();
  //  }
}
