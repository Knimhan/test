package com.heavenhr.web.business.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig
{
    @Bean
    Mapper mapper()
    {
        List<String> mappingFiles = new ArrayList<>();
        mappingFiles.add("dozer/offer-mappings.xml");
        mappingFiles.add("dozer/date-mappings.xml");
        return new DozerBeanMapper(mappingFiles);
    }

}
