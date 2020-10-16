/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;


import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Service.RemoteCallService;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import java.io.File;
import java.io.IOException;
import static org.bouncycastle.cms.RecipientId.password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

        

/**
 *
 * @author backup
 */

@Controller
public class ConsumerControllerClient {
    
    @Autowired
    private RemoteCallService loadBalancer;
     
     /*
     RemoteCallService callService = Feign.builder()
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder()) 
        .contract(new SpringMvcContract())     
        .requestInterceptor(new BasicAuthRequestInterceptor("user2", ""))
        .target(RemoteCallService.class,"http://localhost:8083");
     */
    
    public void getUser() throws RestClientException, IOException {

		try {
		User usr = (User) loadBalancer.getAllUsers();                         
		System.out.println(usr.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
    }
    
}
