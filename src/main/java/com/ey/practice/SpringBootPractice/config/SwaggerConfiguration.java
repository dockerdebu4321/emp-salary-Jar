package com.ey.practice.SpringBootPractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public OpenAPI mySwaggerOpenAPIConfigutation()
	{
		return new OpenAPI()
                .info(new Info().title("My Swagger World")
                                 .description("This page provides diffrent types of employee APIs")
                                 .version("1.0"));
		
	}

}
