package com.sistecredito.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToWebsite implements Task {

    private final String urlWebPage;

    public NavigateToWebsite(String urlWebPage) {
        this.urlWebPage = urlWebPage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(urlWebPage));
    }

    public static Performable withLink(String urlWebPage) {
        return instrumented(NavigateToWebsite.class, urlWebPage);
    }
}
