package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ResultsPageElements extends PageObject {

    private ResultsPageElements() {
    }

    public static final Target LIST_OF_PRODUCTS = Target.the("Button to go to the shopping bag").locatedBy("(//b[contains(@Id, 'testId-pod-displaySubTitle')])[{0}]");
    public static final Target IMG_BANNER_CMR = Target.the("Banner with CMR offer").locatedBy("//img[@class='banner-cmr-notificacion']");
    public static final Target BTN_CLOSE_BANNER_CMR = Target.the("Button for close offer CMR").locatedBy("//div[@class='dy-modal-contents']/div[1]");
    public static final Target RESULTS_QUANTITY = Target.the("Quantity span for results").locatedBy("//span[starts-with(@id, 'testId-') and contains(@id,'totalResults')]");
    public static final Target SMS_PRODUCT_NOT_AVAILABLE = Target.the("Product not available message").locatedBy("//h3[contains(text(),'Lo sentimos, no encontramos resultados')]");
}
