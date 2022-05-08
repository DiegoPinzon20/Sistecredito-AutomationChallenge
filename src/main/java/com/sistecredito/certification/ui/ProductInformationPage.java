package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductInformationPage extends PageObject {
    private ProductInformationPage() {
    }

    public static final Target ADD_TO_BAG_BTN = Target.the("Button to add product to bag").locatedBy("//div[@id='buttonForCustomers']/button");
    public static final Target COUNTER_ITEMS_ONCART = Target.the("Counter items in cart").locatedBy("//i[@data-count]");
}
