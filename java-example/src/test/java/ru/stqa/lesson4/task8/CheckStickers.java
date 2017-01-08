package ru.stqa.lesson4.task8;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;

public class CheckStickers extends BaseTest{


    @Test
    public void goAllSections() {
        driver.navigate().to("http://localhost/litecart/en/");
        List<WebElement> allGoodsItems = driver.findElements(By.cssSelector("div.image-wrapper"));
        for (int i=0; i < allGoodsItems.size(); i++ ){

            Assert.assertEquals("A sticker is founded",1,allGoodsItems.get(i).findElements(By.cssSelector("div.sticker")).size());
//            System.out.println("allGoodsItems.get("+i+").findElements(By.cssSelector(\"div.sticker\"))" + allGoodsItems.get(i).findElements(By.cssSelector("div.sticker")).get(0).getText());
    }
    }


}
