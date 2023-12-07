package com.net.stackthread.controllers;


import com.net.stackthread.dto.UserDto;
import com.net.stackthread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
//        Optional<UserDto> optionalUser = userRepository.findById(id);
//        return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//
//    @GetMapping("/username/{username}")
//    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
//        UserDto user = userRepository.findByUsername(username);
//        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
//    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Boolean> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @PostMapping("/login" )
    public ResponseEntity<Boolean> login(@RequestBody UserDto userDto) {
        boolean authenticate = userService.login(userDto);
        return (authenticate) ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto updatedUser) {
//        Optional<UserDto> optionalUser = userRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            updatedUser.setId(id);
//            UserDto savedUser = userRepository.save(updatedUser);
//            return ResponseEntity.ok(savedUser);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//        Optional<UserDto> optionalUser = userRepository.findById(id);
//        if (optionalUser.isPresent()) {
//            userRepository.delete(optionalUser.get());
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
