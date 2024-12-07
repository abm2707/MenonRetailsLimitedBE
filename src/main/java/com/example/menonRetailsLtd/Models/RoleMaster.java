package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class RoleMaster {

    private final String status = "ACTIVE";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roleId;
    private String roleName;
    private String roleDescription;
    private Integer roleLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
