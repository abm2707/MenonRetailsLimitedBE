package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.ScreenAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenAccessRepo extends JpaRepository<ScreenAccess, ScreenAccess> {
    @Query("SELECT sa.screenId\n" +
            "\t,sm.displayName\n" +
            "\t,sm.screenPath\n" +
            "FROM ScreenAccess sa\n" +
            "INNER JOIN ScreenMaster sm ON sa.screenId = sm.screenId\n" +
            "WHERE sa.Role = :role\n")
    List<Object[]> findScreensByRole(@Param("role") String role);
}
