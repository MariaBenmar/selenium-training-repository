package ru.stqa.lesson11.task19;

/**
 * Created by Maria on 1/26/2017.
 */
public class ProductDetails {

    private String  locatorAddToCartButton, locatorCheckoutProductQuantity, locatorSelectOptionSize;

    public static ProductDetails.Builder newEntity() {
        return new ProductDetails().new Builder();
    }


    public String getAddToCartButton() {
        return locatorAddToCartButton;
    }

    public String getCheckoutProductQuantity() {
        return locatorCheckoutProductQuantity;
    }

    public String getSelectOptionSize() {
        return locatorSelectOptionSize;
    }



    public class Builder {
        private Builder() {}
        public ProductDetails.Builder withAddToCartButton(String locatorAddToCartButton) { ProductDetails.this.locatorAddToCartButton = locatorAddToCartButton; return this; }
        public ProductDetails.Builder withCheckoutProductQuantity(String locatorCheckoutProductQuantity) { ProductDetails.this.locatorCheckoutProductQuantity = locatorCheckoutProductQuantity; return this; }
        public ProductDetails.Builder withSelectOptionSize(String locatorSelectOptionSize) { ProductDetails.this.locatorSelectOptionSize = locatorSelectOptionSize; return this; }
        public ProductDetails build() {return ProductDetails.this; }
    }

}
