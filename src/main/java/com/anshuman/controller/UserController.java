package com.anshuman.controller;

import com.anshuman.DTO.Request.UserRequest;
import com.anshuman.DTO.Response.UserResponse;
import com.anshuman.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome to Xpress ";
    }

    @PostMapping("/Registeration")
    public UserResponse registerUser(@RequestBody UserRequest request){
        return userService.registerUser(request);
    }


}
