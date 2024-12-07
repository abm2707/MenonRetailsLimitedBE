package com.example.menonRetailsLtd.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartMaster {
    @Id
    @Column(name = "cartid")  // Mapping field to column
    private String cartID;

    @Column(name = "access_id")  // Mapping field to column
    private String accessId;

    @Column(name = "net_amt")  // Mapping field to column
    private String netAmt;

    @Column(name = "local_tax")  // Mapping field to column
    private String localTax;

    @Column(name = "gross_amt")  // Mapping field to column
    private String grossAmt;

    @Column(name = "shipping_address")  // Mapping field to column
    private String shippingAddress;

    @Column(name = "billed_to")  // Mapping field to column
    private String billedTo;

    @Column(name = "payment_method")  // Mapping field to column
    private String paymentMethod;

    @Column(name = "order_status")  // Mapping field to column
    private String orderStatus;
}

