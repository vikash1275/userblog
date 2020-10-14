/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Service.RemoteCallService;
import feign.Contract;
import feign.Feign;
import io.swagger.models.Model;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author backup
 */
/** implementing the feign client   */

@RestController
@RequiredArgsConstructor
public class AppController {
    
    @Autowired
    private RemoteCallService loadBalancer;
         
    @GetMapping("/getUsers")
    public List <User> getUsers() {
    return loadBalancer.getAllUsers();
    }
    
    
}
