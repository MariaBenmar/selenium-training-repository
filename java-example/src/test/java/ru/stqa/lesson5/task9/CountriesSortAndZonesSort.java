package ru.stqa.lesson5.task9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lenovo on 09.01.2017.
 */
public class CountriesSortAndZonesSort extends BaseTest{
    public Boolean isSortedListString(List<String> list){
        List<String> newList = new ArrayList(list);
        Collections.sort(list);
        return list.equals(newList);
    }

    @Test
    public void  countriesSortAndZonesSort(){
            driver.navigate().to("http://localhost/litecart/admin/");
            driver.findElement(By.name("username")).sendKeys("admin");
            driver.findElement(By.name("password")).sendKeys("admin");
            driver.findElement(By.name("login")).click();

            List<WebElement> rowCountries = driver.findElements(By.cssSelector("name=countries_form] tr.row"));
            List<WebElement> countryNames = driver.findElements(By.cssSelector("name=countries_form] tr.rowntd:nth-child(5)"));
    }
}
