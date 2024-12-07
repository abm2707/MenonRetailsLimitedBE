package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.CartMaster;
import com.example.menonRetailsLtd.Repositories.CartMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartMasterService {

    @Autowired
    CartMasterRepo cartMasterRepo;

    public void saveProductsToCart(CartMaster cartMaster) {
        cartMasterRepo.save(cartMaster);
    }
}
