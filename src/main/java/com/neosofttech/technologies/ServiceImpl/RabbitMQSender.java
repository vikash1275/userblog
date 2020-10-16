/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.ServiceImpl;


import com.neosofttech.technologies.Domain.Role;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author backup
 */

@Service
public class RabbitMQSender {
    
    @Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Role rl) {
		rabbitTemplate.convertAndSend(exchange, routingkey, rl);
		System.out.println("Send msg = " + rl);
	    
	}
}
