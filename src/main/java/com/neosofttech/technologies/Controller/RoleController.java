/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.Role;
import com.neosofttech.technologies.Service.RoleService;
import com.neosofttech.technologies.Service.UserService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author backup
 */


@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    RoleService roleservice;
    
    
    @PostMapping("/addrole")
    public ResponseEntity<Object> addRole(@RequestBody Role role)
    {	    	
    	roleservice.addRole(role);
        URI path= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("(role)")
                .buildAndExpand(role.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    
    @PutMapping("/role/{id}")
    public Role updateRole(@RequestBody Role role, @PathVariable int id) {
           return roleservice.update(id, role);
    }

    
}
