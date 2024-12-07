package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.CartMaster;
import com.example.menonRetailsLtd.Services.CartMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addPrdToCart")
public class CartMasterController {

    @Autowired
    CartMasterService cartMasterService;

    String resp;

    @PostMapping("/add")
    public String saveProductsToCart(@RequestBody CartMaster cartMaster){
        try {
            cartMasterService.saveProductsToCart(cartMaster);
            resp = "3";
            return resp;
        } catch (Exception e) {
            resp = "5";
            return resp;
        }
    }
}
