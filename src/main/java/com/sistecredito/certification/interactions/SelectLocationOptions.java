package com.sistecredito.certification.interactions;

import com.sistecredito.certification.models.AddressInformationModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sistecredito.certification.ui.ProductDispatchForm.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectLocationOptions implements Interaction {

    private final AddressInformationModel addressInformationModel;

    public SelectLocationOptions(AddressInformationModel addressInformationModel) {
        this.addressInformationModel = addressInformationModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(addressInformationModel.getEmailAddress()).into(INPUT_EMAIL_TXT),
                Click.on(BUTTON_CONTINUE_EMAIL),
                WaitUntil.the(MESSAGE_POST_VALIDATE_EMAIL, isVisible()).forNoMoreThan(20).seconds(),
                SelectFromOptions.byVisibleText(addressInformationModel.getState().toUpperCase()).from(SELECT_REGION),
                SelectFromOptions.byVisibleText(addressInformationModel.getCity().toUpperCase()).from(SELECT_CITY),
                SelectFromOptions.byVisibleText(addressInformationModel.getCity().toUpperCase()).from(SELECT_NEIGHBORHOOD),
                Click.on(BUTTON_CONTINUE_PAYMENT),
                WaitUntil.the(INPUT_ADDRESS_TXT, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable withInformation(AddressInformationModel addressInformationModel) {
        return instrumented(SelectLocationOptions.class, addressInformationModel);
    }
}
