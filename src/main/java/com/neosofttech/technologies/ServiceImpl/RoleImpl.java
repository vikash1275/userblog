/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.ServiceImpl;

import com.neosofttech.technologies.Domain.Role;
import com.neosofttech.technologies.Repository.RoleRepository;
import com.neosofttech.technologies.Service.RoleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author backup
 */
@Component
public class RoleImpl implements RoleService{
    
    @Autowired
    RoleRepository rolerepository;

    @Override
    public Role addRole(Role role) {
        return rolerepository.save(role);
    }

    @Override
    public Optional getById(int id) {
     return rolerepository.findById(id);

    }

    @Override
    public String deleteRoleById(int id) {
       String msg;
         rolerepository.deleteById(id);
         return msg="deleted";
    }

    @Override
    public Role update(int id, Role role) {
                return (Role) rolerepository.save(role);

    }
    
}
