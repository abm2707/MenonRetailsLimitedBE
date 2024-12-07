package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_role_mapping")
@Data
public class UserRoleMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer recordId;

    private String accessId; // Primary key

    private String role;

}