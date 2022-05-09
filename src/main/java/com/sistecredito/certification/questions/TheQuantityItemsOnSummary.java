package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sistecredito.certification.ui.OrderSummary.QUANTITY_PRODUCT_SUMMARY;

@Subject("the quantity items on summary of purchase")
public class TheQuantityItemsOnSummary implements Question<Integer> {

    private static final Logger LOGGER = LogManager.getLogger(TheQuantityItemsOnSummary.class);

    @Override
    public Integer answeredBy(Actor actor) {
        int currentQuantity = Integer.parseInt(Text.of(QUANTITY_PRODUCT_SUMMARY).asString().answeredBy(actor).replace(" un.", ""));
        LOGGER.info("{} sees in the basket {} added products", actor.getName(), currentQuantity);
        return currentQuantity;
    }

    public static TheQuantityItemsOnSummary onCart(){
        return new TheQuantityItemsOnSummary();
    }
}
