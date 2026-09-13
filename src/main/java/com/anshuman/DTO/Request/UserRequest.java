package com.anshuman.DTO.Request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private String password;
}
