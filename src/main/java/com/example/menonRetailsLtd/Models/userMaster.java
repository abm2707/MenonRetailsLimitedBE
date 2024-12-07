package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class userMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "access_id")
    private String accessId;

    @Column(name = "password")
    private String password;

    @Column(name = "card_id")
    private String CartId;

    @Column(name = "otp")
    private String Otp;

    @Column(name = "status")
    private String Status;
}
