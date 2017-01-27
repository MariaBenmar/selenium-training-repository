package ru.stqa.lesson11.task19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * Created by Maria on 1/27/2017.
 */
public class MainStorePage extends Page {
    public MainStorePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainStorePage open() {
        driver.get("http://localhost/litecart/admin/?app=customers&doc=customers");
        return this;
    }

    @FindBy(css = "table.dataTable tr.row")
    private List<WebElement> customerRows;

    public Set<String> getCustomerIds() {
        return customerRows.stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText())
                .collect(toSet());
    }

}
