package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.SellerMaster;
import com.example.menonRetailsLtd.Services.SellerMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerMasterRepo extends JpaRepository<SellerMaster, String> {

}
