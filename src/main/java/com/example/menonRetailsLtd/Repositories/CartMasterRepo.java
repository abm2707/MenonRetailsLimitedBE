package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Controllers.CartMasterController;
import com.example.menonRetailsLtd.Models.CartMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMasterRepo extends JpaRepository<CartMaster, String> {
}
