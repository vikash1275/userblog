/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.ServiceImpl;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

/**
 *
 * @author backup
 */

/** Implementing Rabbit MQ */

@Component
public class Receiver 
{
    
  private CountDownLatch latch = new CountDownLatch(1);

  public void receiveMessage(String message) {
    System.out.println("Received <" + message + ">");
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }
    
}
