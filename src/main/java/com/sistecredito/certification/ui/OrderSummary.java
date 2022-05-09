package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OrderSummary extends PageObject {
    private OrderSummary() {
    }

    public static final Target PRODUCT_NAME_SUMMARY = Target.the("Selected product name").locatedBy("(//div[contains(@class,'orderSummary') and contains(@class,'itemDetails')]/div[1]/span[contains(@class, 'name')])[1]");
    public static final Target QUANTITY_PRODUCT_SUMMARY = Target.the("Quantity selected units of product").locatedBy("(//div[contains(@class,'orderSummary__quantity')][1])[1]");

}
