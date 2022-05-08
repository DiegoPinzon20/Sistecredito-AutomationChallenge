package com.sistecredito.certification.stepdefinitions;

import com.sistecredito.certification.models.AddressInformationModel;
import com.sistecredito.certification.models.ProductModel;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class ModelTypeDef {

    @DataTableType
    public ProductModel defineProductModel(Map<String, String> entry) {
        return new ProductModel(
                entry.get("expectedQuantity"),
                entry.get("expectedTitle")
        );
    }

    @DataTableType
    public AddressInformationModel defineAddressInfoModel(Map<String, String> entry) {
        return new AddressInformationModel(
                entry.get("emailAddress"),
                entry.get("state"),
                entry.get("city"),
                entry.get("address"),
                entry.get("aditionalAddress")
        );
    }
}
