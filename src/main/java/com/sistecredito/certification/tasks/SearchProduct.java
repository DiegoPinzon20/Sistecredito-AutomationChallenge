package com.sistecredito.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sistecredito.certification.ui.MainPageElements.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchProduct implements Task {

    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {d
        actor.attemptsTo(
                Enter.theValue(productName).into(INPUT_SEARCH).then(Click.on(BUTTON_SEARCH))
        );
    }

    public static Performable byName(String productName) {
        return instrumented(SearchProduct.class, productName);
    }
}
