package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.userMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<userMaster, Integer> {
    userMaster findByaccessId(String username);
}
