package com.sistecredito.certification.stepdefinitions.add_products;

import com.sistecredito.certification.exceptions.ValidationProductName;
import com.sistecredito.certification.exceptions.ValidationQuantity;
import com.sistecredito.certification.models.ProductModel;
import com.sistecredito.certification.questions.TheProductName;
import com.sistecredito.certification.questions.TheQuantityItems;
import com.sistecredito.certification.tasks.NavigateToWebsite;
import com.sistecredito.certification.tasks.SearchProduct;
import com.sistecredito.certification.tasks.SelectFirstProductAndAddToCart;
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


public class AddProductsToCartStepDefinitions {

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
                SelectFirstProductAndAddToCart.withQuantity(quantity)
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
}
