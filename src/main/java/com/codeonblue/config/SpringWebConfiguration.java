package com.codeonblue.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@Configuration
public class SpringWebConfiguration {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return ( container -> {
            ErrorPage custom404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            container.addErrorPages(custom404Page);
        });
    }

    @Bean
    public Java8TimeDialect java8TimeDialect(){
        return new Java8TimeDialect();
    }


}
