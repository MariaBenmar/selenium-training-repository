package ru.stqa.lesson5.task9;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lenovo on 14.01.2017.
 */
public class GeoZonesSortForCountries extends BaseTest {
    public Boolean isSortedListString(List<String> list){
        List<String> newList = new ArrayList(list);
        Collections.sort(list);
        return list.equals(newList);
    }

    @Test
    public void  geoZonesSortForCountries(){
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        WebElement mainMenuItemCountries = driver.findElement(By.cssSelector("td#sidebar li#app-:nth-child(6) a"));
        mainMenuItemCountries.click();



    }




}
