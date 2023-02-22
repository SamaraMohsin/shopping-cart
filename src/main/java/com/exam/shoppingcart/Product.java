package com.exam.shoppingcart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_image", columnDefinition= "Text")
    private String prodImg;

    @Column(name = "product_name")
    private String prodName;

    @Column(name = "product_short_description" ,columnDefinition= "Text" )
    private String shortDescription;

    @Column(name = "product_price")
    private Double prodPrice;

    @Column(name = "product_quantity" ,nullable = false )
    private Integer prodQuantity;


}
