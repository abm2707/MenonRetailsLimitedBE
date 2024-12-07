package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.ClaimMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimMasterRepo extends JpaRepository<ClaimMaster, String> {
}
