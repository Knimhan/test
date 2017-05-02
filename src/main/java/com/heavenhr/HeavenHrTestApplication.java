package com.heavenhr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.heavenhr.database.dao" })
@EnableAspectJAutoProxy
@EnableSwagger2
public class HeavenHrTestApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HeavenHrTestApplication.class, args);
    }
}
