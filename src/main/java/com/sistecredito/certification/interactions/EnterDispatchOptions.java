package com.sistecredito.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.PaymentProductPage.TITLE_ON_PAYMENT_PAGE;
import static com.sistecredito.certification.ui.PopupChangeQuantity.TITLE_CHANGE_QUANTITY;
import static com.sistecredito.certification.ui.ProductDispatchForm.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterDispatchOptions implements Interaction {

    private final String address;
    private final String additionalAddress;

    public EnterDispatchOptions(String address, String additionalAddress) {
        this.address = address;
        this.additionalAddress = additionalAddress;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(address).into(INPUT_ADDRESS_TXT),
                Enter.theValue(additionalAddress).into(ADDITIONAL_INFORMATION_ADDRESS),
                Ensure.that(TITLE_CHANGE_QUANTITY).isNotDisplayed(),
                Click.on(BUTTON_ENTER_ADDRESS),
                WaitUntil.the(BUTTON_TO_PAYMENT, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(BUTTON_TO_PAYMENT),
                WaitUntil.the(TITLE_ON_PAYMENT_PAGE, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable withData(String address, String additionalAddress) {
        return instrumented(EnterDispatchOptions.class, address, additionalAddress);
    }
}
