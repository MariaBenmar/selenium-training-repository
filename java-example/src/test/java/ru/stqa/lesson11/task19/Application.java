package ru.stqa.lesson11.task19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Maria on 1/25/2017.
 */
public class Application {

    private WebDriver driver;

    private MainStorePage mainStorePage;
    private ProductDetailsPage productDetailsPage;
    private CheckoutPage checkoutPage;

    public Application() {
        driver = new ChromeDriver();
        mainStorePage = new MainStorePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void quit() {
        driver.quit();
    }
}