package com.sistecredito.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.sistecredito.certification.ui.PopupOfAddedProducts.ALERT_DONT_AVAILABLE;
import static com.sistecredito.certification.ui.PopupOfAddedProducts.INCREMENT_BUTTON;
import static com.sistecredito.certification.ui.ProductInformationPage.COUNTER_ITEMS_ONCART;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class SelectQuantity implements Interaction {

    private final int quantity;

    public SelectQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement counterElement = getDriver().findElement(By.xpath(COUNTER_ITEMS_ONCART.getCssOrXPathSelector()));

        while (true) {
            if (quantity == Integer.parseInt(counterElement.getAttribute("data-count"))) {
                break;
            } else {
                actor.attemptsTo(
                        WaitUntil.the(INCREMENT_BUTTON, isEnabled()).forNoMoreThan(10).seconds(),
                        Click.on(INCREMENT_BUTTON),
                        Ensure.that(ALERT_DONT_AVAILABLE).isNotDisplayed()
                );
            }
        }
    }
    public static Performable withProduct(int quantity){
        return instrumented(SelectQuantity.class, quantity);
    }
}
