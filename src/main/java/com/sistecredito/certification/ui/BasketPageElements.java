package com.sistecredito.certification.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BasketPageElements extends PageObject {

    private BasketPageElements() {
    }

    public static final Target PRODUCT_NAME =Target.the("Product name").locatedBy("//h4[@class='fb-product__title']");
    public static final Target BASKET_ITEM_COUNTER = Target.the("Boton para ir a la bolsa de compras").locatedBy("//i[contains(@class, 'count') and contains(@class, 'basket')]");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").locatedBy("//button[contains(@class,'js-fb-continue-purchase') or text() = 'Ir a comprar']");
    public static final Target TITLE_SHOPPING_BAG = Target.the("Checkout button").locatedBy("//span[text()='Bolsa de Compras' and @class = 'title']");
}
