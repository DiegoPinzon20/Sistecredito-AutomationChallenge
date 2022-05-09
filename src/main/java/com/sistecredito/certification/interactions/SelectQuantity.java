package com.sistecredito.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.PopupOfAddedProducts.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsOnlyText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectQuantity implements Interaction {

    private final int quantity;

    public SelectQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean flag = true;
        while (flag) {
            if (quantity == Text.of(QUANTITY_TO_ADD).asInteger().answeredBy(actor)) {
                flag = false;
            } else if (quantity == 0) {
                actor.attemptsTo(
                        WaitUntil.the(DECREMENT_BUTTON, isEnabled()).forNoMoreThan(10).seconds(),
                        Click.on(DECREMENT_BUTTON).afterWaitingUntilEnabled(),
                        WaitUntil.the(QUANTITY_TO_ADD, containsOnlyText(String.valueOf(quantity)))
                );
                flag = false;
            } else {
                actor.attemptsTo(
                        WaitUntil.the(INCREMENT_BUTTON, isEnabled()).forNoMoreThan(10).seconds(),
                        Click.on(INCREMENT_BUTTON),
                        Ensure.that(ALERT_DONT_AVAILABLE).isNotDisplayed()
                );
            }
        }
    }

    public static Performable withProduct(int quantity) {
        return instrumented(SelectQuantity.class, quantity);
    }
}
