package com.sistecredito.certification.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;


public class MakePurchaseFalabellaStepDefinitions {

    @Given("{actor} browses the main web page")
    public void actorBrowsesTheMainWebPage(Actor actor) {
    }

    @When("^performs the search for the product (.*)$")
    public void performsTheSearchForTheProduct(String productName) {
    }

    @And("select the first option and add {int}")
    public void selectTheFirstOptionAndAddAnQuantity(int quantity) {
    }

    @Then("the added product should have the following characteristics")
    public void theAddedProductShouldHaveTheFollowingCharacteristics(ProductModel productModelInformation) {
    }

    @And("add the shipping information of the order")
    public void addTheShippingInformationOfTheOrder(AddressInformationModel addressInformationModel) {
    }

    @Then("the purchase summary should contain the following information")
    public void thePurchaseSummaryShouldContainTheFollowingInformation(ProductModel productModelInformation) {
    }
}
