package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MainPageElements extends PageObject {

    private MainPageElements() {
    }

    public static final Target INPUT_SEARCH = Target.the("Text entry to search for a product").locatedBy("//input[@id='testId-SearchBar-Input']");
    public static final Target BUTTON_SEARCH = Target.the("Search button").locatedBy("//Button[contains(@class, 'searchBtnIcon')]");

}
