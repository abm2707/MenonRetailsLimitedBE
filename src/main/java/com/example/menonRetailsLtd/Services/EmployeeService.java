package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.Employee;
import com.example.menonRetailsLtd.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }
}
