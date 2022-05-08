package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ProductDispatchForm extends PageObject {
    private ProductDispatchForm() {
    }

    public static final Target INPUT_EMAIL_TXT = Target.the("Text input to enter the user's email address").locatedBy("//input[@id='emailAddress']");
    public static final Target BUTTON_CONTINUE_EMAIL = Target.the("Continue button after entering email address").locatedBy("//form/div[2]/button");
    public static final Target MESSAGE_POST_VALIDATE_EMAIL = Target.the("Message after email validation").locatedBy("//div/div/p[contains(.,'2 pasos')]");
    public static final Target SELECT_REGION = Target.the("List to select the shipping department").locatedBy("//select[@id='region']");
    public static final Target SELECT_CITY = Target.the("List to select the city for shipment").locatedBy("//select[@id='ciudad']");
    public static final Target SELECT_NEIGHBORHOOD = Target.the("List to select the neighborhood for shipment").locatedBy("//select[@id='comuna']");
    public static final Target BUTTON_CONTINUE_PAYMENT = Target.the("Button to continue payment").locatedBy("//div/button[text()='Continuar']");
    public static final Target INPUT_ADDRESS_TXT = Target.the("Field to enter the delivery address").locatedBy("//input[@id='address']");
    public static final Target ADDITIONAL_INFORMATION_ADDRESS = Target.the("Additional delivery address information").locatedBy("//input[@id='departmentNumber']");
    public static final Target BUTTON_ENTER_ADDRESS = Target.the("Button to save the entered address").locatedBy("//button[@name='useAddress']");
    public static final Target BUTTON_TO_PAYMENT = Target.the("Button to continue to payment").locatedBy("//div/button[text()='Continuar']");
}
