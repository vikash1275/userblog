package com.neosofttech.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCircuitBreaker
@EnableSwagger2
@EnableAutoConfiguration
@EnableEurekaServer
@SpringBootApplication
public class TechnologiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologiesApplication.class, args);
	}
        
        /** implementing docker */
        @Bean
        public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.neosofttech.technologies")).build();
        }
        
        /** implementing rest template */
        @Bean
        public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
        }

}
