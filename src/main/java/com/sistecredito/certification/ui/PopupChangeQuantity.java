package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class PopupChangeQuantity extends PageObject {
    private PopupChangeQuantity() {
    }

    public static final Target TITLE_CHANGE_QUANTITY = Target.the("Title of popup change quantity").locatedBy("//h1[text()='Modificar cantidad']");
    public static final Target BUTTON_CONTINUE_AVALAIBLE_QUANTITY = Target.the("Button for continue with selected quantity").locatedBy("//button[text()='Continuar con estos productos']");
}
