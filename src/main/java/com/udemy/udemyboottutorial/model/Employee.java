package com.udemy.udemyboottutorial.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String empFirstName;

    @Column(name = "last_name", nullable = false)
    private String empLastName;

    @Column(name = "email", nullable = false)
    private String empEmail;

}
