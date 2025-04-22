package com.example.rg.rg_foods_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//All should be in camlcase

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String password;

}
