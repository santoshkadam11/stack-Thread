package com.net.stackthread.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig
{

   @Bean
   public ModelMapper modelMapper()
   {
      ModelMapper mapper = new ModelMapper();
      mapper.getConfiguration().setPropertyCondition(context -> context.getSource() != null);
      return mapper;
   }
}
