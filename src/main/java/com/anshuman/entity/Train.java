package com.anshuman.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Train {

    @Id @GeneratedValue
    long id;

    String trainName;
    int trainNumber;

}
