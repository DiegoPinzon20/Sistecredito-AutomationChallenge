package com.sistecredito.certification.tasks;

import com.sistecredito.certification.interactions.EnterDispatchOptions;
import com.sistecredito.certification.interactions.SelectLocationOptions;
import com.sistecredito.certification.models.AddressInformationModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.sistecredito.certification.ui.BasketPageElements.CHECKOUT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterShippingInformation implements Task {

    private final AddressInformationModel addressInformationModel;

    public EnterShippingInformation(AddressInformationModel addressInformationModel) {
        this.addressInformationModel = addressInformationModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKOUT_BUTTON),
                SelectLocationOptions.withInformation(addressInformationModel),
                EnterDispatchOptions.withData(addressInformationModel.getAddress(), addressInformationModel.getAditionalAddress())
        );
    }

    public static Performable onSite(AddressInformationModel addressInformationModel){
        return instrumented(EnterShippingInformation.class, addressInformationModel);
    }
}
