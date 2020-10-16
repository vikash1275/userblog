/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import com.neosofttech.technologies.Domain.User;
import feign.Headers;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author backup
 */

@FeignClient(name = "user-blog", url = "http://localhost:8083")
public interface RemoteCallService {
    @RequestMapping(value = "/user/findall", method = RequestMethod.GET ,produces = MediaType.APPLICATION_JSON_VALUE)
 public List <User> getAllUsers();    
}
