/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neosofttech.technologies.Controller;

/**
 *
 * @author backup
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.lang.reflect.Type;
import java.util.Collections;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class JacksonEncoder implements Encoder {

  private final ObjectMapper mapper;

  public JacksonEncoder() {
    this(Collections.emptyList());
  }

  public JacksonEncoder(Iterable modules) {
    this(new ObjectMapper()
             .setSerializationInclusion(JsonInclude.Include.NON_NULL)
             .configure(SerializationFeature.INDENT_OUTPUT, true)
             .registerModules(modules));
  }

  public JacksonEncoder(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  @Override
  public void encode(Object object, Type bodyType, RequestTemplate template) {
    try {
      JavaType javaType = mapper.getTypeFactory().constructType(bodyType);
      template.body(mapper.writerFor(javaType).writeValueAsString(object));
    } catch (JsonProcessingException e) {
      throw new EncodeException(e.getMessage(), e);
    }
  }
}