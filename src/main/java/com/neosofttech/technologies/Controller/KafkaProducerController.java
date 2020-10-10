/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

import com.neosofttech.technologies.Service.KafKaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author backup
 */

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {
    
    private final KafKaProducerService producerService;
 
    @Autowired
    public KafkaProducerController(KafKaProducerService producerService) 
    {
        this.producerService = producerService;
    }
 
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) 
    {
        this.producerService.sendMessage(message);
    }
    
}
