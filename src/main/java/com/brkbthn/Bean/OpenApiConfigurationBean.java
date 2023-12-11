package com.brkbthn.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigurationBean {
    @Bean
    public OpenAPI openAPIMethod(){
        return new OpenAPI().info(new Info().title("Başlık Bilgisi").description("Tanımlama").version("v1.0")
                .contact(new Contact().name("berkbthn").url("https//www.brkbthn.com.tr").email("berkbthn@gmail.com"))
                .termsOfService("INC BY ")
                .license(new License().name("License").url("#!")));
    }
}
