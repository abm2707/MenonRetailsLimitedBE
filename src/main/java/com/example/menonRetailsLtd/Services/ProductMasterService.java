package com.example.menonRetailsLtd.Services;

import com.example.menonRetailsLtd.Models.ProductMaster;
import com.example.menonRetailsLtd.Repositories.ProductMasterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductMasterService {

    ProductMasterRepo productMasterRepo;

    public void addProductToCatalg(ProductMaster pm) {
        productMasterRepo.save(pm);
    }

    public List<ProductMaster> searchProduct(String searchVal) {
        return productMasterRepo.searchProducts(searchVal);
    }
}
