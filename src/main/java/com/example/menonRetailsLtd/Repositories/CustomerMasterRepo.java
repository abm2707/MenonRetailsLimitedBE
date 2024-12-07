package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CustomerMasterRepo extends JpaRepository<CustomerMaster, Long> {
    List<CustomerMaster> findByAccessId(String AccessId);
}
