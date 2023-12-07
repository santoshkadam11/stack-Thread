package com.net.stackthread.service.impl;


import com.net.stackthread.dto.UserDto;
import com.net.stackthread.entities.User;
import com.net.stackthread.repositories.UserRepository;
import com.net.stackthread.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl
      implements UserService
{

   private final UserRepository userRepository;
   private final ModelMapper modelMapper;

   @Autowired
   public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper)
   {
      this.userRepository = userRepository;
      this.modelMapper = modelMapper;
   }

   @Override
   public void createUser(UserDto userDto)
   {
      Optional.ofNullable(userRepository.findByUsername(userDto.getUsername())).ifPresent(user -> {
         throw new RuntimeException("User already exists");
      });
      User user = modelMapper.map(userDto, User.class);
      user.saveUniqueSaltForUser();
      user.savePasswordHash(userDto.getPassword());
      user.saveAnswerHash(userDto.getSecurityAnswer());
      userRepository.save(user);

   }

   @Override
   public boolean login(UserDto userDto)
   {
      try {
         User user = userRepository.findByUsername(userDto.getUsername());
         return user.checkPassword(userDto.getPassword());
      }
      catch (Exception e) {
         return false;
      }
   }
}
