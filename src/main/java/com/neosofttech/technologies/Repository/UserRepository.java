/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Repository;

import com.neosofttech.technologies.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

 /**
 *
 * @author backup
 */

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>  {
    
}
