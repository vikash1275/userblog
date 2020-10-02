/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.ServiceImpl;

import com.neosofttech.technologies.Domain.Blog;
import com.neosofttech.technologies.Repository.BlogRepository;
import com.neosofttech.technologies.Service.BlogService;
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
public class BlogImpl implements BlogService {
    
    @Autowired
    BlogRepository  blogrepo;
       

    @Override
    public Blog addBlog(Blog blog) {
             return  (Blog) blogrepo.save(blog);

    }

    @Override
    public Page<Blog> listAll(int pageNum) {
    int pageSize = 5;     
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);     
    return blogrepo.findAll(pageable);
    }

    @Override
    public Optional getById(int id) {
     return blogrepo.findById(id);
    }

    @Override
    public String deleteBlogById(int id) {
         String msg;
         blogrepo.deleteById(id);
         return msg="deleted";
    }

    @Override
    public Blog update(int id, Blog blog) {
                return (Blog) blogrepo.save(blog);
    }
    
}
