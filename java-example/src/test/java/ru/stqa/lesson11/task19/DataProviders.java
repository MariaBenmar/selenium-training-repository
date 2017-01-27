package ru.stqa.lesson11.task19;

import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 * Created by Maria on 1/25/2017.
 */
public class DataProviders {

    @DataProvider
    public static Object[][] dataCheckout() {
        return new Object[][] {
                { MainStore.newEntity()
                .withProductMainPage("div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link").withHomeButton(".general-0 a").withCheckoutLink("#header div#cart-wrapper .link").build() },
                /* ... */

        { ProductDetails.newEntity()
                .withAddToCartButton("[name='add_cart_product']").withCheckoutProductQuantity("div#cart span.quantity").withSelectOptionSize("[name='options[Size]']")
                .build() },
                /* ... */

        { Checkout.newEntity()
                .withProductInCheckout("li.item").withCheckoutRemoveButton("button[name = 'remove_cart_item']").withProductInOrderSummary("div#box-checkout-summary table.dataTable td.item")}

    };
    }


}
