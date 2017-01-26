package ru.stqa.lesson11.task19;

import com.tngtech.java.junit.dataprovider.DataProvider;

/**
 * Created by Maria on 1/25/2017.
 */
public class DataProviders {

    @DataProvider
    public static Object[][] dataCheckout() {
        return new Object[][] {
                { MainPageStore.newEntity()
                .withProductInCheckout("div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link").withSelectOptionSize("Smith").withPhone("+0123456789")
                .withAddress("Hidden Place").withPostcode("12345").withCity("New City")
                .withCountry("US").withZone("KS")
                .withEmail("adam"+System.currentTimeMillis()+"@smith.me")
                .withPassword("qwerty").build() },
                /* ... */

        { ProductDetails.newEntity()
                .withProductInCheckout("div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link").withSelectOptionSize("Smith").withPhone("+0123456789")
                .withAddress("Hidden Place").withPostcode("12345").withCity("New City")
                .withCountry("US").withZone("KS")
                .withEmail("adam"+System.currentTimeMillis()+"@smith.me")
                .withPassword("qwerty").build() },
                /* ... */

        { Checkout.newEntity()
                .withProductInCheckout("div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link").withCheckoutRemoveButton("Smith").withProductInOrderSummary("+0123456789")}

    };
    }


}
