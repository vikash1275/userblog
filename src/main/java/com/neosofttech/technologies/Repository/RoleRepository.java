/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Repository;

import com.neosofttech.technologies.Domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author backup
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer>{
    
}
