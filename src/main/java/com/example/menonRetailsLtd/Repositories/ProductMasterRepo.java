package com.example.menonRetailsLtd.Repositories;

import com.example.menonRetailsLtd.Models.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProductMasterRepo extends JpaRepository<ProductMaster, BigInteger> {

    @Query("SELECT p FROM ProductMaster p WHERE " +
            "p.productName LIKE %:searchVal% OR " +
            "p.Brand LIKE %:searchVal% OR " +
            "p.Category LIKE %:searchVal%")
    List<ProductMaster> searchProducts(@Param("searchVal") String searchVal);

}
