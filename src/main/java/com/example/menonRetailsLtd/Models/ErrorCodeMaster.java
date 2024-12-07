package com.example.menonRetailsLtd.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ErrorCodeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer errorId;
    private String errorDesc;
    private String errStatus;
}
