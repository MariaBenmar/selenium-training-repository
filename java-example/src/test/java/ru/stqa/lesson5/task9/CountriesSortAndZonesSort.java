package ru.stqa.lesson5.task9;

import org.junit.Assert;
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

            WebElement mainMenuItemCountries = driver.findElement(By.cssSelector("td#sidebar li#app-:nth-child(3) a"));
            mainMenuItemCountries.click();
            List<WebElement> countriesNames = driver.findElements(By.cssSelector("[name=countries_form] tr.row td:nth-child(5)"));
            List <String> countryNamesText = new ArrayList<>();

            for (WebElement country : countriesNames){
                countryNamesText.add(country.getAttribute("outerText"));
          //      System.out.println(country.getAttribute("outerText"));
            }
            Assert.assertTrue("A list isn't sorted by alphabetical", isSortedListString(countryNamesText));

            for (int i = 0; i < countriesNames.size(); i++) {
                List<WebElement> countriesRows = driver.findElements(By.cssSelector("[name=countries_form] tr.row"));
                WebElement countryZoneValue = countriesRows.get(i).findElement(By.cssSelector("td:nth-child(6)"));
                int countryZoneNumber = Integer.valueOf(countryZoneValue.getAttribute("innerText"));

                if (countryZoneNumber > 0) {
                    countriesNames = driver.findElements(By.cssSelector("[name=countries_form] tr.row td:nth-child(5)"));
                    countriesNames.get(i).findElement(By.cssSelector("a")).click();
                    List<WebElement> zoneNamesForCountry = driver.findElements(By.cssSelector("table#table-zones tr > td:nth-child(3)"));
                    List <String> zoneNamesForCountryText = new ArrayList<>();

                    for (int j = 0; j < zoneNamesForCountry.size()-1; j++) {
                        zoneNamesForCountryText.add(zoneNamesForCountry.get(j).getAttribute("innerText"));
          //              System.out.println(zoneNamesForCountryText.get(j));
                    }
//
                    Assert.assertTrue("A list isn't sorted by alphabetical", isSortedListString(zoneNamesForCountryText));
                    driver.findElement(By.cssSelector("button[name = 'cancel']")).click();
            }
        }
    }
}
