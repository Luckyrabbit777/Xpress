package com.anshuman.controller;

import com.anshuman.DTO.Request.UserRequest;
import com.anshuman.DTO.Response.UserResponse;
import com.anshuman.Service.UserService;
import com.anshuman.entity.User;
import com.anshuman.storage.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome to Xpress ";
    }

    @GetMapping("/user/{id}")
        public UserResponse getUserById(@PathVariable Long id){
            return userService.getUserById(id);
        }

    @PostMapping("/Registeration")
    public UserResponse registerUser(@RequestBody UserRequest request){
        return userService.registerUser(request);
    }

    @PutMapping("user/{id}")
    public UserResponse updateUser(@PathVariable long id,@RequestBody UserRequest request){
        return userService.updateUser(request,id);
    }

}
