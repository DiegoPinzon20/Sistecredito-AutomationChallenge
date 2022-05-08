package com.sistecredito.certification.models;

import lombok.Data;

@Data
public class ProductModel {
    private final Integer quantity;
    private final String expectedTitle;

    public ProductModel(String quantity, String expectedTitle) {
        this.quantity = Integer.valueOf(quantity);
        this.expectedTitle = expectedTitle;
    }
}