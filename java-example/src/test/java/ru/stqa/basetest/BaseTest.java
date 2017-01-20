package ru.stqa.basetest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 08.01.2017.
 */
public class BaseTest {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public void loginToAdmin () {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    public boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }
    public void clickElementByLocator(String text) {
        driver.findElement(By.cssSelector(text)).click();
    }

    public void fillText(String text, String locatorSearch){
        WebElement locator = driver.findElement(By.cssSelector(locatorSearch));
        locator.clear();
        locator.sendKeys(text);
    }

    public void fillSelectForm(String code, String locatorSearch) {
        Select menuItem = new Select(driver.findElement(By.cssSelector(locatorSearch)));
        menuItem.selectByValue(code);
    }
    public void setElementByName(String name, String locator, String tagName){
        List<WebElement> Elements = driver.findElements(By.cssSelector(locator));
        ListIterator listIterator = Elements.listIterator();
        for (WebElement element : Elements){
            if (name.equals(element.getAttribute(tagName))){

                Elements.get(listIterator.previousIndex()).click();
            }
        }
    }

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> {driver.quit(); driver = null; }));
    }

    @After
     public void stop() {
//         driver.quit();
//         driver = null;
     }
}
