package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "email_config")
public class EmailConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateId;


    @Column(name = "email_header", columnDefinition = "TEXT")
    private String emailHeader;


    @Column(name = "email_footer", columnDefinition = "TEXT")
    private String emailFooter;


    @Column(name = "email_body", columnDefinition = "TEXT")
    private String emailBody;

    @Column(name = "subject")
    private String subject;

    @Column(name = "to_email")
    private String toEmail;

    @Column(name = "from_email")
    private String fromEmail;
}
