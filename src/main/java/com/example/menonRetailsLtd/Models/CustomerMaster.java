package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CustomerMaster {

    @Id
    @Column(name = "access_id")
    private String accessId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "cartid")
    private String CartID;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private String status = "ACTIVE";

    @Column(name = "otp")
    private String otp;

    @Column(name = "otp_gen_time")
    private LocalDateTime otpGenTime;
}
