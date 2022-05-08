package com.sistecredito.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.MainPageElements.*;
import static com.sistecredito.certification.ui.ResultsPageElements.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProduct implements Task {

    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(productName).into(INPUT_SEARCH).then(Click.on(BUTTON_SEARCH)),
                WaitUntil.the(RESULTS_QUANTITY, isVisible()).forNoMoreThan(30).seconds()
        );

        actor.attemptsTo(Check.whether(IMG_BANNER_CMR.isVisibleFor(actor)).andIfSo(Click.on(BTN_CLOSE_BANNER_CMR)));
        while (true) {
            if (IMG_BANNER_CMR.isVisibleFor(actor)) {
                actor.attemptsTo(Click.on(BTN_CLOSE_BANNER_CMR));
            } else {
                break;
            }
        }
    }

    public static Performable byName(String productName) {
        return instrumented(SearchProduct.class, productName);
    }
}
