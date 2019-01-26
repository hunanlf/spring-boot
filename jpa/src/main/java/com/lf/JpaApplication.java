package com.lf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class JpaApplication extends SpringBootServletInitializer {

	/** Tomcat 发布 extends SpringBootServletInitializer */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JpaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


}
