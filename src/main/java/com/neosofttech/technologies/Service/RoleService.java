/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import com.neosofttech.technologies.Domain.Role;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author backup
 */

@Service
public interface RoleService {
       public Role addRole(Role role);
        public Optional getById(int id);
        public String deleteRoleById(int id);
        public Role update(int id, Role role);
    
}
