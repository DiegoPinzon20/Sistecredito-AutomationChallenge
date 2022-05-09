package com.sistecredito.certification.stepdefinitions.search_unavailable_product;

import com.sistecredito.certification.questions.TheProductNotAvailable;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class SearchUnavailableProductStepDefinitions {

    @Then("should see the message of products not available")
    public void shouldSeeTheMessageOfProductsNotAvailable() {
        theActorInTheSpotlight().should(
                seeThat(TheProductNotAvailable.message(), equalTo(true))
        );
    }
}
