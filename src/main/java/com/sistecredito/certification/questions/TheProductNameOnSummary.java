package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.sistecredito.certification.ui.OrderSummary.PRODUCT_NAME_SUMMARY;

@Subject("the product name of item on summary of purchase")
public class TheProductNameOnSummary implements Question<String> {

    private static final Logger LOGGER = LogManager.getLogger(TheProductNameOnSummary.class);

    @Override
    public String answeredBy(Actor actor) {
        String currentProductName = Text.of(PRODUCT_NAME_SUMMARY).answeredBy(actor);
        LOGGER.info("{} sees the name {} added to the cart", actor.getName(), currentProductName);
        return currentProductName;
    }

    public static TheProductNameOnSummary ofItem(){
        return new TheProductNameOnSummary();
    }
}