package com.sistecredito.certification.tasks;

import com.sistecredito.certification.interactions.AddQuantityProducts;
import com.sistecredito.certification.interactions.SelectProductFromList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.ProductInformationPage.ADD_TO_BAG_BTN;
import static com.sistecredito.certification.ui.ResultsPageElements.*;
import static com.sistecredito.certification.utils.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectFirstProductAndAddToCart implements Task {

    private final int quantity;

    public SelectFirstProductAndAddToCart(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(RESULTS_QUANTITY, isVisible()).forNoMoreThan(30).seconds(),
                Check.whether(IMG_BANNER_CMR.isVisibleFor(actor)).andIfSo(Click.on(BTN_CLOSE_BANNER_CMR))
        );

        while (true) {
            if (IMG_BANNER_CMR.isVisibleFor(actor)) {
                actor.attemptsTo(Click.on(BTN_CLOSE_BANNER_CMR));
            } else {
                break;
            }
        }

        actor.attemptsTo(
                Ensure.that(quantity).isNotNull(),
                SelectProductFromList.withPosition(ONE_NUMBER),
                WaitUntil.the(ADD_TO_BAG_BTN, isVisible()).forNoMoreThan(30).seconds(),
                AddQuantityProducts.withQuantity(quantity)
        );
    }

    public static Performable withQuantity(int quantity) {
        return instrumented(SelectFirstProductAndAddToCart.class, quantity);
    }
}
