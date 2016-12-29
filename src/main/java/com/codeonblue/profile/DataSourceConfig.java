package com.codeonblue.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {


    @Bean
    @Profile("development")
    public DataSource development(){
       return new DataSource("my-development-url",9999);
    }


    @Bean
    @Profile("production")
    public DataSource production(){
        return new DataSource("my-production-url",9999);
    }

}
