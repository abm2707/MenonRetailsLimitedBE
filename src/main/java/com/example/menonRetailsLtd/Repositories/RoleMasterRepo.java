package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleMasterRepo extends JpaRepository<RoleMaster, Integer> {
}
