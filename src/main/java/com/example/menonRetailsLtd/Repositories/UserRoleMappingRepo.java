package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMappingRepo extends JpaRepository<UserRoleMapping, Integer> {

    @Query("SELECT urm.role FROM UserRoleMapping urm WHERE urm.accessId = :accessId")
    String getRolesByAccessId(String accessId);
}
