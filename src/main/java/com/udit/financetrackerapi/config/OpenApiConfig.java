package com.udit.financetrackerapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI financeTrackerOpenAPI() {

        Contact contact = new Contact()
                .name("Udit K Jain")
                .url("https://www.linkedin.com/in/udit-k-jain-03bbbb245/");

        Info info = new Info()
                .title("Finance Tracker API")
                .description("""
                        REST API for managing personal finance transactions.

                        👨‍💻 Developed by Udit K Jain

                        GitHub:
                        https://github.com/uditjain15
                        """)
                .version("v1.0")
                .contact(contact);

        return new OpenAPI()
                .info(info);
    }
}