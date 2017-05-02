package com.heavenhr.web.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{

    @Bean
    public Docket api()
    {
        // @formatter:off
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("HeavenHR ", "REST services", "0.0.1", null, new Contact("Kumudini", "http://heavenhr.de", null), null, null))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.heavenhr"))
                .build();
        // @formatter:on
    }
}