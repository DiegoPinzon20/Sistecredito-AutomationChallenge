package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.sistecredito.certification.ui.ResultsPageElements.SMS_PRODUCT_NOT_AVAILABLE;

@Subject("the product not available message")
public class TheProductNotAvailable implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return SMS_PRODUCT_NOT_AVAILABLE.isVisibleFor(actor);
    }

    public static TheProductNotAvailable message(){
        return new TheProductNotAvailable();
    }
}