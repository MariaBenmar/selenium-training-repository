package ru.stqa.lesson11.task19;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 1/27/2017.
 */
public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private boolean isElementPresent(WebDriver driver, By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isElementNotPresent(WebDriver driver, By locator){
        try{
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return  driver.findElements(locator).size()==0;
        }
        finally{
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    public void clickElementByLocator(String text) {
        driver.findElement(By.cssSelector(text)).click();
    }

    public void fillText(String text, String locatorSearch){
        WebElement locator = driver.findElement(By.cssSelector(locatorSearch));
        locator.clear();
        locator.sendKeys(text);
    }
    public void setText(String text, String locatorSearch){
        WebElement locator = driver.findElement(By.cssSelector(locatorSearch));
        locator.sendKeys(text);
    }
    public void fillSelectForm(String code, String locatorSearch) {
        Select menuItem = new Select(driver.findElement(By.cssSelector(locatorSearch)));
        menuItem.selectByValue(code);
    }
    public void fillSelectVisibleForm(String code, String locatorSearch) {
        Select menuItem = new Select(driver.findElement(By.cssSelector(locatorSearch)));
        menuItem.selectByVisibleText(code);
    }

    public void setElementByName(String name, String locator, String tagName){
        List<WebElement> elements = driver.findElements(By.cssSelector(locator));

        for (int i=0; i < elements.size(); i++) {
            if (name.equals(elements.get(i).getAttribute(tagName))) {
                if (elements.get(i).getTagName().equals("input")) {
                    elements.get(i).click();
                }
                else {
                    elements.get(i-1).findElement(By.tagName("input")).click();
                }
            }
        }
    }

    public void switchToNewWindowCloseAndReturn(WebElement link) {

        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        link.click();
        String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);
//       System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(mainWindow);

    }

    public ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>() {

            public String apply(WebDriver webDriver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }

}
