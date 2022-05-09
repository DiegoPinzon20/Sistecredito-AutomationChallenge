package com.sistecredito.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.BasketPageElements.TITLE_SHOPPING_BAG;
import static com.sistecredito.certification.ui.PopupOfAddedProducts.BUTTON_GO_CART;
import static com.sistecredito.certification.ui.PopupOfAddedProducts.POPUP_ADD_PRODUCT;
import static com.sistecredito.certification.ui.ProductInformationPage.ADD_TO_BAG_BTN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddQuantityProducts implements Interaction {

    private final int quantity;

    public AddQuantityProducts(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ADD_TO_BAG_BTN),
                WaitUntil.the(POPUP_ADD_PRODUCT, isVisible()).forNoMoreThan(20).seconds(),
                Check.whether(quantity == 1).otherwise(SelectQuantity.withProduct(quantity)),
                Click.on(BUTTON_GO_CART),
                WaitUntil.the(TITLE_SHOPPING_BAG, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable withQuantity(int quantity) {
        return instrumented(AddQuantityProducts.class, quantity);
    }
}
