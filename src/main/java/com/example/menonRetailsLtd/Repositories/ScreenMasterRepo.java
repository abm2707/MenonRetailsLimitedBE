package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.ScreenMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenMasterRepo extends JpaRepository<ScreenMaster, Integer> {

}
