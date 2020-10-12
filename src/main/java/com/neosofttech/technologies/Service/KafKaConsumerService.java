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
import org.springframework.stereotype.Service;



        
        

/**
 *
 * @author backup
 */

@Service
public class KafKaConsumerService {
    
    private final Logger logger = 
            LoggerFactory.getLogger(KafKaConsumerService.class);
 
    @KafkaListener(topics = AppConstants.TOPIC_NAME,groupId = AppConstants.GROUP_ID)
    public void consume(String message) 
    {
        logger.info(String.format("Message recieved -> %s", message));
    }
    
}
