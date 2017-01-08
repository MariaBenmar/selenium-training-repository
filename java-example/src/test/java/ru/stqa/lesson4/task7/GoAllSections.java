package ru.stqa.lesson4.task7;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoAllSections {

        private WebDriver driver;
        private WebDriverWait wait;
        private boolean isElementPresent(WebDriver driver, By locator) {
                try {
                        driver.findElement(locator);
                        return true;
                } catch (NoSuchElementException ex) {
                        return false;
                }
        }
        private boolean areElementsPresent(WebDriver driver, By locator) {
                return driver.findElements(locator).size() > 0;
        }

//self.browser.implicitly_wait(10)
        @Before
        public void start() {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                wait = new WebDriverWait(driver, 10);
        }


        @Test
        public void goAllSections() {
                driver.navigate().to("http://localhost/litecart/admin/");
                driver.findElement(By.name("username")).sendKeys("admin");
                driver.findElement(By.name("password")).sendKeys("admin");
                driver.findElement(By.name("login")).click();
                List<WebElement> mainMenuItems = driver.findElements(By.cssSelector("td#sidebar li#app-"));
                for (int i=0; i < mainMenuItems.size(); i++) {
                        mainMenuItems = driver.findElements(By.cssSelector("td#sidebar li#app-"));
                        mainMenuItems.get(i).findElement(By.cssSelector("a")).click();
                        mainMenuItems = driver.findElements(By.cssSelector("td#sidebar li#app-"));
                        List<WebElement>  subMenuItems = mainMenuItems.get(i).findElements(By.cssSelector("ul.docs a"));
                        if (subMenuItems.size() > 0) {
                                for (int j = 0; j < subMenuItems.size(); j++) {
                                        mainMenuItems = driver.findElements(By.cssSelector("td#sidebar li#app-"));
                                        subMenuItems = mainMenuItems.get(i).findElements(By.cssSelector("ul.docs a"));
                                        subMenuItems.get(j).click();
                                        Assert.assertTrue(areElementsPresent(driver, By.cssSelector("td#content h1")));
                                }
                        }
                        Assert.assertTrue(areElementsPresent(driver, By.cssSelector("td#content h1")));
                }

        }
        @After
        public void quit(){
                driver.quit();
                driver = null;
        }
}