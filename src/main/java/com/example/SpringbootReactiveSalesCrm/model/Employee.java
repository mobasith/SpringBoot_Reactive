package com.example.SpringbootReactiveSalesCrm.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Employee")
public class Employee {
    @Id
    private String eid;
    private String Name;
    private String email;
    private String phone;
    private String company;
    private String industry;
    private String Department;
}

