package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PaymentProductPage extends PageObject {
    private PaymentProductPage() {
    }

    public static final Target TITLE_ON_PAYMENT_PAGE = Target.the("Title on the payment page").locatedBy("//h2[contains(., 'medio de pago')]");
}
