package com.anshuman.DTO.Response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private int age;
    private String email;
    private String message;
}
