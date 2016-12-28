package com.codeonblue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class SpringBootWebAppOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebAppOneApplication.class, args);
	}

}
