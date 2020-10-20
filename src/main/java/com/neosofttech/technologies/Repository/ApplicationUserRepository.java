/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Repository;

import com.neosofttech.technologies.Domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long>{
    ApplicationUser findByUsername(String username);
}
