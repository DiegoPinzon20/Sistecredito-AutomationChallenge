package com.sistecredito.certification.stepdefinitions.add_zero_products;

import com.sistecredito.certification.exceptions.ValidationQuantity;
import com.sistecredito.certification.questions.TheQuantityItems;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import static com.sistecredito.certification.ui.BasketPageElements.PRODUCT_NAME;
import static com.sistecredito.certification.utils.constants.Constants.ZERO_NUMBER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static org.hamcrest.Matchers.equalTo;


public class AddZeroProductsToCartStepDefinitions {

    @Then("should see the basket empty")
    public void shouldSeeTheBasketEmpty() {
        theActorInTheSpotlight().should(
                seeThat(TheQuantityItems.onCart(), equalTo(ZERO_NUMBER))
                        .orComplainWith(ValidationQuantity.class, ValidationQuantity.VALIDATION_DO_NOT_MATCH),
                seeThat(WebElementQuestion.the(PRODUCT_NAME), isNotVisible())
        );
    }
}
