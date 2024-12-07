package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<EmailConfig, Long> {
}
