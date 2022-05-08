package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PopupOfAddedProducts extends PageObject {

    private PopupOfAddedProducts() {
    }

    public static final Target POPUP_ADD_PRODUCT = Target.the("Popup with purchase information").locatedBy("//div[contains(@class,'popup')]");
    public static final Target BUTTON_GO_CART = Target.the("Button to go to shopping bag").locatedBy("//div[contains(@class, 'addToCart-btn')]/a");
    public static final Target DECREMENT_BUTTON = Target.the("Button to decrease the number of products").locatedBy("//button[@id='testId-stepper-decrement-btn']");
    public static final Target INCREMENT_BUTTON = Target.the("Button to increase the number of products").locatedBy("//button[@id='testId-stepper-increment-btn']");
    public static final Target QUANTITY_TO_ADD = Target.the("Current value of items to be added").locatedBy("//div[contains(@class,'product-count-value')]");
    public static final Target ALERT_DONT_AVAILABLE = Target.the("Alert product quantity dont available").locatedBy("//span[contains(@class,'warning-icon-alert')]");
}
