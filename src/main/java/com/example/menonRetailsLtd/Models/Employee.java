package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employeeConfig")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Lob
    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

    private String department;
    private double salary;
}
