package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.userMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterRepo extends JpaRepository<userMaster, Integer> {

    @Query("SELECT c from CustomerMaster c where c.accessId = :accessId")
    public List<Object[]> findUserDetails(@Param("accessId") String accessId);
}
