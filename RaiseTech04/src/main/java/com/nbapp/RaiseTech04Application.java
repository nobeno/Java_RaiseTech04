package com.nbapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RaiseTech04Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RaiseTech04Application.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RaiseTech04Application.class);
    }

}
