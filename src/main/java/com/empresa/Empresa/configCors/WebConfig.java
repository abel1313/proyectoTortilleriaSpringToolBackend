package com.empresa.Empresa.configCors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/empresa/sistema/**")
		.allowedOrigins("http://127.0.0.1:4200")
		.allowedOrigins("http://192.168.1.73:8080/empresa/sistema")
		.allowedOrigins("http://192.168.31.79:8080/empresa/sistema")
		.allowedOrigins("*")
		.allowedMethods("GET", "POST")
		.maxAge(3600);
		
		
	}
	
	
}
