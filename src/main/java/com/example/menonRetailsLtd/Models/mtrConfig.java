package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wp_mtr_config")
public class mtrConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer Id;

    private String config_key;

    private String config_value;

    private String config_value2;

}
