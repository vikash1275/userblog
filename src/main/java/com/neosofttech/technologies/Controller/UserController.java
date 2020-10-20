/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.ApplicationUser;
import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Repository.ApplicationUserRepository;
import com.neosofttech.technologies.Repository.UserRepository;
import com.neosofttech.technologies.Service.UserService;
import io.swagger.models.Model;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    
    /**  Spring Authentication Part */
    
    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
    
    /** User Controller Service  */
    @Autowired
    UserService userservice;
    
    @Autowired
    UserRepository usrrepo;
   
    @RequestMapping("/page/{pageNum}/{pagesize}")
    public List<User> viewPage(Model model,
    @PathVariable(name = "pageNum") int pageNum,@PathVariable(name = "pagesize") int pagesize)
    {  

    Page<User> page = userservice.listAll(pageNum,pagesize);
    List<User> listProducts = page.getContent();
    int pagetotal=page.getTotalPages();
    return listProducts;

    }
    
    @RequestMapping("/findall")
    public List<User> getUsers()
    {  

    return (List<User>) usrrepo.findAll();
    
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
