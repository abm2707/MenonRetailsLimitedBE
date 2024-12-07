package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.ErrorCodeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ErrorMasterRepo extends JpaRepository<ErrorCodeMaster, Integer> {
    Optional<ErrorCodeMaster> findById(Integer errId);
}
