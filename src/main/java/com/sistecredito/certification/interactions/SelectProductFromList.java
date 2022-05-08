package com.sistecredito.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.certification.ui.ProductInformationPage.ADD_TO_BAG_BTN;
import static com.sistecredito.certification.ui.ResultsPageElements.LIST_OF_PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectProductFromList implements Interaction {

    private final int position;

    public SelectProductFromList(int position) {
        this.position = position;
    }

    @Override
    @Step("{0} select producto with position #position")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LIST_OF_PRODUCTS.of(String.valueOf(position))),
                WaitUntil.the(ADD_TO_BAG_BTN, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable withPosition(int position){
        return instrumented(SelectProductFromList.class, position);
    }
}
