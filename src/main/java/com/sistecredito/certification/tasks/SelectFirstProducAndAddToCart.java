package com.sistecredito.certification.tasks;

import com.sistecredito.certification.interactions.AddQuantityProducts;
import com.sistecredito.certification.interactions.SelectProductFromList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.ProductInformationPage.ADD_TO_BAG_BTN;
import static com.sistecredito.certification.utils.constants.Constants.ONE_NUMBER;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectFirstProducAndAddToCart implements Task {

    private final int quantity;

    public SelectFirstProducAndAddToCart(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectProductFromList.withPosition(ONE_NUMBER),
                WaitUntil.the(ADD_TO_BAG_BTN, isVisible()).forNoMoreThan(30).seconds(),
                AddQuantityProducts.withQuantity(quantity)
        );
    }

    public static Performable withQuantity(int quantity) {
        return instrumented(SelectFirstProducAndAddToCart.class, quantity);
    }
}
