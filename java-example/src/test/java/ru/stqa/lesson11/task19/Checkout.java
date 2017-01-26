package ru.stqa.lesson11.task19;

//import javafx.util.Builder;

/**
 * Created by Maria on 1/25/2017.
 */
public class Checkout {

    private String locatorProductMainPage, locatorAddToCartButton, locatorHomeButton,locatorCheckoutLink,
            locatorProductInCheckout,locatorCheckoutRemoveButton, locatorCheckoutProductQuantity,locatorProductInOrderSummary,
            locatorSelectOptionSize;

    public static Builder newEntity() {
        return new Checkout().new Builder();
               }


    public String getProductInCheckout() {
        return locatorProductInCheckout;
    }

    public String getCheckoutRemoveButton() {
        return locatorCheckoutRemoveButton;
    }

    public String getProductInOrderSummary() {
        return locatorProductInOrderSummary;
    }



    public class Builder {
        private Builder() {}
        public Builder withProductInCheckout(String locatorProductInCheckout) { Checkout.this.locatorProductInCheckout = locatorProductInCheckout; return this; }
        public Builder withCheckoutRemoveButton(String locatorCheckoutRemoveButton) { Checkout.this.locatorCheckoutRemoveButton = locatorCheckoutRemoveButton; return this; }
        public Builder withProductInOrderSummary(String locatorProductInOrderSummary) { Checkout.this.locatorProductInOrderSummary = locatorProductInOrderSummary; return this; }
    }

}
