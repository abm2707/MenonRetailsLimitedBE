package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Services.ScreenAccessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/screenAccess")
public class ScreenAccessController {

    @Autowired
    ScreenAccessServices screenAccessServices;

    @GetMapping("/screens/{Role}")
    public List<Object[]> getAccessibleScreens(@PathVariable Integer Role) {
        System.out.println("Role: "+Role);
        return screenAccessServices.getAccessibleScreens(String.valueOf(Role));
    }
}
