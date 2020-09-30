/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import com.neosofttech.technologies.DTO.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author backup
 */

@Service
public interface UserService  {
    
    
        public User addUser(User user);
	public Page<User> listAll(int pageNum);
        public Optional getById(int id);
        public String deleteUserById(int id);
        public User update(int id, User user);
        
}
