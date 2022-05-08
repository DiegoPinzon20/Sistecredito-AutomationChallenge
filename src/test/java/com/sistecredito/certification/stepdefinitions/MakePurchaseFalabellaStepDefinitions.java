package com.sistecredito.certification.stepdefinitions;

import com.sistecredito.certification.exceptions.ValidationProductName;
import com.sistecredito.certification.exceptions.ValidationQuantity;
import com.sistecredito.certification.models.AddressInformationModel;
import com.sistecredito.certification.models.ProductModel;
import com.sistecredito.certification.questions.TheProductName;
import com.sistecredito.certification.questions.TheProductNameOnSummary;
import com.sistecredito.certification.questions.TheQuantityItems;
import com.sistecredito.certification.questions.TheQuantityItemsOnSummary;
import com.sistecredito.certification.tasks.EnterShippingInformation;
import com.sistecredito.certification.tasks.NavigateToWebsite;
import com.sistecredito.certification.tasks.SearchProduct;
import com.sistecredito.certification.tasks.SelectFirstProducAndAddToCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static com.sistecredito.certification.utils.constants.WebPageLinks.FALABELLA_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;


public class MakePurchaseFalabellaStepDefinitions {

    @Given("{actor} browses the main web page")
    public void actorBrowsesTheMainWebPage(Actor actor) {
        actor.wasAbleTo(NavigateToWebsite.withLink(FALABELLA_PAGE));
    }

    @When("^performs the search for the product (.*)$")
    public void performsTheSearchForTheProduct(String productName) {
        theActorInTheSpotlight().attemptsTo(
                SearchProduct.byName(productName)
        );
    }

    @And("select the first option and add {int}")
    public void selectTheFirstOptionAndAddAnQuantity(int quantity) {
        theActorInTheSpotlight().attemptsTo(
                SelectFirstProducAndAddToCart.withQuantity(quantity)
        );
    }

    @Then("the added product should have the following characteristics")
    public void theAddedProductShouldHaveTheFollowingCharacteristics(ProductModel productModelInformation) {
        theActorInTheSpotlight().should(
                seeThat(TheQuantityItems.onCart(), equalTo(productModelInformation.getQuantity()))
                        .orComplainWith(ValidationQuantity.class, ValidationQuantity.VALIDATION_DO_NOT_MATCH),
                seeThat(TheProductName.ofItem(), containsStringIgnoringCase(productModelInformation.getExpectedTitle()))
                        .orComplainWith(ValidationProductName.class, ValidationProductName.VALIDATION_DO_NOT_CONTAIN_TEXT)
        );
    }

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
