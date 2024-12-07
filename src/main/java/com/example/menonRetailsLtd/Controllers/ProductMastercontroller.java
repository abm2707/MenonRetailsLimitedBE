package com.example.menonRetailsLtd.Controllers;

import com.example.menonRetailsLtd.Models.ProductMaster;
import com.example.menonRetailsLtd.Services.ProductMasterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductMastercontroller {

    ProductMasterService productMasterService;

    @PostMapping("/addProduct")
    public String addProductToCatalog(@RequestBody ProductMaster pm){
        try {
            productMasterService.addProductToCatalg(pm);
            return "success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<ProductMaster> SearchProducts(@PathVariable String searchVal){
        try {
            return productMasterService.searchProduct(searchVal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
