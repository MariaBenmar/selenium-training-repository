package ru.stqa.lesson11.task19;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Created by Lenovo on 25.01.2017.
 */
@RunWith(DataProviderRunner.class)
public class AddProductToBasketAndDeletePageObjects extends TestBase{
    public String locatorProductMainPage, locatorAddToCartButton, locatorHomeButton,locatorCheckoutLink,
            locatorProductInCheckout,locatorCheckoutRemoveButton, locatorCheckoutProductQuantity,locatorProductInOrderSummary,
            locatorSelectOptionSize;
    public List<WebElement> productMainPageList, productInCheckoutList, productsInOrderSummaryList;


    @Test
    @UseDataProvider(value = "dataCheckout" , location = DataProviders.class)
    public void addProductToBasketAndDeletePageObjects(){
        driver.get("http://localhost/litecart/");

        locatorProductMainPage = "div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link";
        locatorSelectOptionSize = "[name='options[Size]']";
        locatorAddToCartButton = "[name='add_cart_product']";
        locatorCheckoutProductQuantity ="div#cart span.quantity";
        locatorHomeButton = ".general-0 a";
        locatorCheckoutLink = "#header div#cart-wrapper .link";
        locatorProductInCheckout = "li.item";
        locatorCheckoutRemoveButton = "button[name = 'remove_cart_item']";
        locatorProductInOrderSummary = "div#box-checkout-summary table.dataTable td.item";

        for(int i =0; i < 3; i++){
            productMainPageList = driver.findElements(By.cssSelector(locatorProductMainPage));
            Random randomInt = new Random();
            productMainPageList.get(randomInt.nextInt(productMainPageList.size())).click();

            if (!isElementNotPresent(driver, By.cssSelector(locatorSelectOptionSize))) {
                fillSelectForm("Small", locatorSelectOptionSize);
            }
            clickElementByLocator(locatorAddToCartButton);
            //wait until product appeares in Checkout
            wait.until(textToBePresentInElement(driver.findElement(By.cssSelector(locatorCheckoutProductQuantity)),Integer.toString(i+1)));
            clickElementByLocator(locatorHomeButton);
        }

        clickElementByLocator(locatorCheckoutLink);
        productInCheckoutList =  driver.findElements(By.cssSelector(locatorProductInCheckout));

        for (int i=0; i < productInCheckoutList.size(); i++){
            productsInOrderSummaryList = driver.findElements(By.cssSelector(locatorProductInOrderSummary));
            clickElementByLocator(locatorCheckoutRemoveButton);
            //wait until product was removed in Order Summary table
            wait.until(stalenessOf(productsInOrderSummaryList.get(productInCheckoutList.size()-i-1)));
        }
    }
}
