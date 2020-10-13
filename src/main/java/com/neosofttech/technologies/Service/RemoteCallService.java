/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import com.neosofttech.technologies.Domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author backup
 */

@FeignClient(name="user-blog")
public interface RemoteCallService {
    @RequestMapping(method=RequestMethod.GET, value="/user/page/{pagenum}/{pagesize}")
	public User getData(@PathVariable(name = "pageNum") int pageNum,@PathVariable(name = "pagesize") int pagesize);

    
}
