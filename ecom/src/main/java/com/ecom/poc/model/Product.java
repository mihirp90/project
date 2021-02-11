package com.ecom.poc.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer productId;
    private String productName;
    private Double price;
    private String brand;
    private String color;

}
