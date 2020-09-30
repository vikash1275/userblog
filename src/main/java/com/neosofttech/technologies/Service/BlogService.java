/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import com.neosofttech.technologies.DTO.Blog;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author backup
 */

@Service
public interface BlogService {
    
        public Blog addBlog(Blog blog);
	public Page<Blog> listAll(int pageNum);
        public Optional getById(int id);
        public String deleteBlogById(int id);
        public Blog update(int id, Blog blog);
    
}
