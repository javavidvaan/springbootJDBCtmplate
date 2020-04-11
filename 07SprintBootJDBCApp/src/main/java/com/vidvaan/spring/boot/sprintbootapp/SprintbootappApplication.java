package com.vidvaan.spring.boot.sprintbootapp;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
public class SprintbootappApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(SprintbootappApplication.class, args);
	
		String[] beans = appContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println("bean Name : " + bean);
			}}
		
//		@Bean
//		public 	Docket swaggerconfigaration() {
//
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/employee/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.vidvaan"))
//				.build()
//		        .apiInfo(apiDetails());
//		}
//		  private ApiInfo apiDetails() {
//			return new ApiInfo(
//					"Employee Controller API",
//					"Sample API For Vidvaan",
//					"1.0",
//					"Free To Use",
//					new springfox.documentation.service.Contact("chandrakanth","http://vidvaan","a@b.com"),
//					"API Licence",
//					"http://vidvaan",
//					Collections.emptyList());
//					
//		  }	
		}
	


