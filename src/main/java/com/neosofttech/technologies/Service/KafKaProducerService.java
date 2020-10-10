/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate; 

/**
 *
 * @author backup
 */

@Service
public class KafKaProducerService {
    
    private static final Logger logger = 
            LoggerFactory.getLogger(KafKaProducerService.class);
     
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    public void sendMessage(String message) 
    {
        logger.info(String.format("Message sent -> %s", message));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
    }
    
}
