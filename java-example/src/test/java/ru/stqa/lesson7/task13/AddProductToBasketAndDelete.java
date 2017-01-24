package ru.stqa.lesson7.task13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;
import java.util.Random;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * Created by Lenovo on 21.01.2017.
 */
public class AddProductToBasketAndDelete extends BaseTest{

    public String locatorProductMainPage, locatorAddToCartButton, locatorHomeButton,locatorCheckoutLink,
            locatorProductInCheckout,locatorCheckoutRemoveButton, locatorCheckoutProductQuantity,locatorProductInOrderSummary,
            locatorSelectOptionSize;
    public List<WebElement> productMainPageList, productInCheckoutList, productsInOrderSummaryList;

    @Test
    public void AddRandomProductsToBasketAndDeleteThemTest(){

        driver.get("http://localhost/litecart/");

        locatorProductMainPage = "div.content ul.listing-wrapper.products li.product.column.shadow.hover-light a.link";
        locatorSelectOptionSize = "[name='options[Size]']";
        locatorAddToCartButton = "[name='add_cart_product'";
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
        productsInOrderSummaryList = driver.findElements(By.cssSelector(locatorProductInOrderSummary));
        System.out.println("locatorProductInCheckout = "+driver.findElements(By.cssSelector(locatorProductInCheckout)).size());
        System.out.println("locatorProductInOrderSummary = "+driver.findElements(By.cssSelector(locatorProductInOrderSummary)).size());
        for (int i=0; i < productInCheckoutList.size(); i++){


            clickElementByLocator(locatorCheckoutRemoveButton);
            //wait until product was removed in Order Summary table
            System.out.println("productsInOrderSummaryList1 = "+driver.findElements(By.cssSelector(locatorProductInOrderSummary)).size());
            System.out.println(stalenessOf(productsInOrderSummaryList.get(i)));



            wait.until(stalenessOf(productsInOrderSummaryList.get(productInCheckoutList.size()-1)));
            System.out.println("productsInOrderSummaryList2 = "+driver.findElements(By.cssSelector(locatorProductInOrderSummary)).size());

        }
    }
}
