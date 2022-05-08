package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sistecredito.certification.ui.BasketPageElements.BASKET_ITEM_COUNTER;

@Subject("the quantity items on cart")
public class TheQuantityItems implements Question<Integer> {

    private static final Logger LOGGER = LogManager.getLogger(TheQuantityItems.class);

    @Override
    public Integer answeredBy(Actor actor) {
        int currentQuantity = Text.of(BASKET_ITEM_COUNTER).asInteger().answeredBy(actor);
        LOGGER.info("{} sees in the basket {} added products", actor.getName(), currentQuantity);
        return currentQuantity;
    }

    public static TheQuantityItems onCart(){
        return new TheQuantityItems();
    }
}
