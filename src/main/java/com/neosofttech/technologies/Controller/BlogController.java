/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Domain.Blog;
import com.neosofttech.technologies.Service.BlogService;
import io.swagger.models.Model;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author backup
 */

@RestController
@RequestMapping("/blog")
public class BlogController {
    
    @Autowired
    BlogService blogservice;
     
    @RequestMapping("/page/{pageNum}/{pagesize}")
    public List<Blog> viewPage(Model model,
    @PathVariable(name = "pageNum") int pageNum,@PathVariable(name = "pagesize") int pagesize)
    {  
        
    Page<Blog> page = blogservice.listAll(pageNum,pagesize);
    List<Blog> listProducts = page.getContent();
    int pagetotal=page.getTotalPages();
    return listProducts;

    }
    
   
    @PostMapping("/addblog")
    public ResponseEntity<Object> addUser(@RequestBody Blog blog)
    {	    	
    	blogservice.addBlog(blog);
        URI path= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("(user)")
                .buildAndExpand(blog.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    
   
    @PutMapping("/editblog/{id}")
    public Blog updateBlog(@RequestBody Blog newblog, @PathVariable int id) {
           return blogservice.update(id, newblog);
    }
  
}