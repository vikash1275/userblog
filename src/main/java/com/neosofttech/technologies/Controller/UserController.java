/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Service.UserService;
import io.swagger.models.Model;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author backup
 */

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userservice;
   
    @RequestMapping("/page/{pageNum}")
    public List<User> viewPage(Model model,
    @PathVariable(name = "pageNum") int pageNum)
    {  

    Page<User> page = userservice.listAll(pageNum);
    List<User> listProducts = page.getContent();
    int pagetotal=page.getTotalPages();
    return listProducts;

    }
    
    @PostMapping("/adduser")
    public ResponseEntity<Object> addUser(@RequestBody User user)
    {	    	
    	userservice.addUser(user);
        URI path= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("(user)")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    
    
   
}
