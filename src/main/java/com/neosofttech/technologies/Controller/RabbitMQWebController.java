/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;


import com.neosofttech.technologies.Domain.Role;
import com.neosofttech.technologies.ServiceImpl.RabbitMQSender;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author backup
 */

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {
        
        @Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer/{Name}/{Id}")
	public String producer(@PathVariable("Name") String Name,@PathVariable("Id") int Id) 
        {
	
	Role rl=new Role();
	rl.setId(Id);
	rl.setName(Name);
	rabbitMQSender.send(rl);
	return "Message sent to the RabbitMQ JavaInUse Successfully";
	
        }
    
}
