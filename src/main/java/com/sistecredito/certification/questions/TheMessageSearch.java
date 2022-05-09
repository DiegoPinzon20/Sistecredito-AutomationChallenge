package com.sistecredito.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.sistecredito.certification.ui.MainPageElements.EMPTY_SEARCH_SMS;

@Subject("the message empty search")
public class TheMessageSearch implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return EMPTY_SEARCH_SMS.isVisibleFor(actor);
    }

    public static TheMessageSearch isEmpty(){
        return new TheMessageSearch();
    }
}