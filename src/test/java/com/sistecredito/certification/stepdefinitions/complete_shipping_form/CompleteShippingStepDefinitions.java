package com.sistecredito.certification.stepdefinitions.complete_shipping_form;

import com.sistecredito.certification.exceptions.ValidationProductName;
import com.sistecredito.certification.exceptions.ValidationQuantity;
import com.sistecredito.certification.models.AddressInformationModel;
import com.sistecredito.certification.models.ProductModel;
import com.sistecredito.certification.questions.TheProductNameOnSummary;
import com.sistecredito.certification.questions.TheQuantityItemsOnSummary;
import com.sistecredito.certification.tasks.EnterShippingInformation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

public class CompleteShippingStepDefinitions {
    @And("add the shipping information of the order")
    public void addTheShippingInformationOfTheOrder(AddressInformationModel addressInformationModel) {
        theActorInTheSpotlight().attemptsTo(
                EnterShippingInformation.onSite(addressInformationModel)
        );
    }

    @Then("the purchase summary should contain the following information")
    public void thePurchaseSummaryShouldContainTheFollowingInformation(ProductModel productModelInformation) {
        theActorInTheSpotlight().should(
                seeThat(TheProductNameOnSummary.ofItem(), containsStringIgnoringCase(productModelInformation.getExpectedTitle()))
                        .orComplainWith(ValidationProductName.class, ValidationProductName.VALIDATION_DO_NOT_CONTAIN_TEXT),
                seeThat(TheQuantityItemsOnSummary.onCart(), equalTo(productModelInformation.getQuantity()))
                        .orComplainWith(ValidationQuantity.class, ValidationQuantity.VALIDATION_DO_NOT_MATCH)
        );
    }
}
