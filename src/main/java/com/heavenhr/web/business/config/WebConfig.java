package com.heavenhr.web.business.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder()
    {
        Jackson2ObjectMapperBuilder objectMapperBuilder = new Jackson2ObjectMapperBuilder();
        objectMapperBuilder.timeZone(TimeZone.getDefault());
        objectMapperBuilder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapperBuilder.modulesToInstall(new Jdk8Module());
        objectMapperBuilder.modulesToInstall(new JavaTimeModule());
        return objectMapperBuilder;
    }
}