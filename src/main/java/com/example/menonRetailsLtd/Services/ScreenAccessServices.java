package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Repositories.ScreenAccessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenAccessServices {

    @Autowired
    ScreenAccessRepo screenAccessRepo;

    public List<Object[]> getAccessibleScreens(String Role) {
        return screenAccessRepo.findScreensByRole(Role);
    }

}
