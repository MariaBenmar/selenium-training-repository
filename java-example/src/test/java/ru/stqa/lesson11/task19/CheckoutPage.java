package ru.stqa.lesson11.task19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Maria on 1/27/2017.
 */
public class CheckoutPage extends Page {

        public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/en/create_account");
    }

}
