package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.UserRoleMapping;
import com.example.menonRetailsLtd.Repositories.UserRoleMappingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleMappingService {

    @Autowired
    UserRoleMappingRepo userRoleMappingRepo;

    public String getRolesByAccessId(String accessId) {
        return userRoleMappingRepo.getRolesByAccessId(accessId);
    }
}
