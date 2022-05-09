package com.sistecredito.certification.stepdefinitions.empty_search;

import com.sistecredito.certification.questions.TheMessageSearch;
import com.sistecredito.certification.questions.TheProductNotAvailable;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class EmptySearchStepDefinitions {

    @Then("should see the search empty message")
    public void shouldSeeTheSearchEmptyMessage() {
        theActorInTheSpotlight().should(
                seeThat(TheMessageSearch.isEmpty(), equalTo(true))
        );
    }
}
