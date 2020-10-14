/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Service.RemoteCallService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public void getUser() throws RestClientException, IOException {

		try {
			User usr = (User) loadBalancer.getAllUsers();                        
			System.out.println(usr.getId());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

    
}
