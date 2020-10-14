/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.ServiceImpl;

import com.neosofttech.technologies.Domain.User;
import com.neosofttech.technologies.Repository.UserRepository;
import com.neosofttech.technologies.Service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

 /**
 *
 * @author backup
 */
@Component
public class UserImpl implements UserService{
    
    @Autowired
    UserRepository userrepo;
    
    @Override
    public User addUser(User user) {
     return  (User) userrepo.save(user);
    }

    
    public Page<User> listAll(int pageNum,int pagesize) {
      
    Pageable pageable = PageRequest.of(pageNum - 1, pagesize);     
    return userrepo.findAll(pageable);
    }

    
    @Override
    public Optional getById(int id) {
        return userrepo.findById(id);
    }

    @Override
    public String deleteUserById(int id) {
         String msg;
         userrepo.deleteById(id);
         return msg="deleted";
    }

    @Override
    public User update(int id, User user) {   
        return userrepo.save(user);
    }
    
}
