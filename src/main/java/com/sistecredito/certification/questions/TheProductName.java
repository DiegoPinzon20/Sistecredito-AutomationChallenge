package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sistecredito.certification.ui.BasketPageElements.PRODUCT_NAME;

@Subject("the product name of item on cart")
public class TheProductName implements Question<String> {

    private static final Logger LOGGER = LogManager.getLogger(TheProductName.class);

    @Override
    public String answeredBy(Actor actor) {
        String currentProductName = Text.of(PRODUCT_NAME).answeredBy(actor);
        LOGGER.info("{} sees the name {} added to the cart", actor.getName(), currentProductName);
        return currentProductName;
    }

    public static TheProductName ofItem(){
        return new TheProductName();
    }
}