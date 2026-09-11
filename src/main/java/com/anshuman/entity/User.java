package com.anshuman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class User {
    @Id @GeneratedValue
Long id;

String name;
int age;
String phoneNumber;
String email;
String password;

}
