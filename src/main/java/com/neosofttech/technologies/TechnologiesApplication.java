package com.neosofttech.technologies;

import com.neosofttech.technologies.Controller.ConsumerControllerClient;
import com.neosofttech.technologies.ServiceImpl.Receiver;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;


@EnableFeignClients
@EnableCircuitBreaker
@EnableSwagger2
@EnableAutoConfiguration
@EnableEurekaServer
@SpringBootApplication
public class TechnologiesApplication {
    
	public static void main(String[] args)  {
		ApplicationContext ctx =SpringApplication.run(TechnologiesApplication.class, args);
               
              /*  ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getUser();
	      */
                }
        
        /** implementing netflix feign client */
        @Bean
	public ConsumerControllerClient consumerControllerClient() {
		return new ConsumerControllerClient();
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
