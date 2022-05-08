package com.sistecredito.certification.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/make_falabella_purchase.feature",
        glue = "com.sistecredito.certification.stepdefinitions",
//        tags = "@CompleteAddressInformation",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/serenity-reports/make_alabella_purchase/serenity-html-report.html",
                "rerun:target/serenity-reports/make_alabella_purchase/rerun.txt"
        }
)
public class MakePurchaseFalabellaRunner {
}
