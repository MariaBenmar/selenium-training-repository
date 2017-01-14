package ru.stqa.lesson5.task10;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

/**
 * Created by Lenovo on 14.01.2017.
 */
public class CheckProductDetails extends BaseTest{

    @Test
    public void  checkProductDetails() {
        driver.navigate().to("http://localhost/litecart/en/");
        WebElement product;
        String mainPageProductText,mainPageProductRegPriceText,mainPageProductSalePriceText,mainPageProductRegPriceColor,mainPageProductSalePriceColor,mainPageProductRegPriceFontSize,mainPageProductSalePriceFontSize,mainPageProductRegPriceFontStyle,mainPageProductSalePriceFontStyle;
        String detailsPageProductText,detailsPageProductRegPriceText,detailsPageProductSalePriceText,detailsPageProductRegPriceColor,detailsPageProductSalePriceColor,detailsPageProductRegPriceFontSize,detailsPageProductSalePriceFontSize,detailsPageProductRegPriceFontStyle,detailsPageProductSalePriceFontStyle;

        product = driver.findElements(By.cssSelector("div#box-campaigns a")).get(0);
        mainPageProductText = product.findElement(By.cssSelector("div.name")).getAttribute("innerText");

        mainPageProductRegPriceText = product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getAttribute("innerText");
        mainPageProductRegPriceColor = product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("color");
        mainPageProductRegPriceFontSize = product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("font-size");
        mainPageProductRegPriceFontStyle = product.findElement(By.cssSelector("div.price-wrapper .regular-price")).getCssValue("text-decoration");

        mainPageProductSalePriceText = product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getAttribute("innerText");
        mainPageProductSalePriceColor = product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("color");
        mainPageProductSalePriceFontSize = product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("font-size");
        mainPageProductSalePriceFontStyle = product.findElement(By.cssSelector("div.price-wrapper .campaign-price")).getCssValue("font-weight");

        Assert.assertThat(mainPageProductRegPriceColor, IsEqual.equalTo("rgba(119, 119, 119, 1)"));
        Assert.assertThat(mainPageProductRegPriceFontSize, IsEqual.equalTo("14.4px"));
        Assert.assertThat(mainPageProductRegPriceFontStyle, IsEqual.equalTo("line-through"));

        Assert.assertThat(mainPageProductSalePriceColor, IsEqual.equalTo("rgba(204, 0, 0, 1)"));
        Assert.assertThat(mainPageProductSalePriceFontSize, IsEqual.equalTo("18px"));
        Assert.assertThat(mainPageProductSalePriceFontStyle, IsEqual.equalTo("bold"));

        product.click();

        detailsPageProductText = driver.findElement(By.cssSelector("div#box-product h1.title")).getAttribute("innerText");

        detailsPageProductRegPriceText = driver.findElement(By.cssSelector("div.information div.price-wrapper .regular-price")).getAttribute("innerText");
        detailsPageProductRegPriceColor = driver.findElement(By.cssSelector("div#box-product div.price-wrapper .regular-price")).getCssValue("color");
        detailsPageProductRegPriceFontSize = driver.findElement(By.cssSelector("div.information div.price-wrapper .regular-price")).getCssValue("font-size");
        detailsPageProductRegPriceFontStyle = driver.findElement(By.cssSelector("div.information div.price-wrapper .regular-price")).getCssValue("text-decoration");

        detailsPageProductSalePriceText = driver.findElement(By.cssSelector("div.information div.price-wrapper .campaign-price")).getAttribute("innerText");
        detailsPageProductSalePriceColor = driver.findElement(By.cssSelector("div.information div.price-wrapper .campaign-price")).getCssValue("color");
        detailsPageProductSalePriceFontSize = driver.findElement(By.cssSelector("div.information div.price-wrapper .campaign-price")).getCssValue("font-size");
        detailsPageProductSalePriceFontStyle = driver.findElement(By.cssSelector("div.information div.price-wrapper .campaign-price")).getCssValue("font-weight");

        Assert.assertThat(mainPageProductText, IsEqual.equalTo(detailsPageProductText));
        Assert.assertThat(mainPageProductRegPriceText, IsEqual.equalTo(detailsPageProductRegPriceText));
        Assert.assertThat(mainPageProductSalePriceText, IsEqual.equalTo(detailsPageProductSalePriceText));

        Assert.assertThat(detailsPageProductRegPriceColor, IsEqual.equalTo("rgba(102, 102, 102, 1)"));
        Assert.assertThat(detailsPageProductRegPriceFontSize, IsEqual.equalTo("16px"));
        Assert.assertThat(detailsPageProductRegPriceFontStyle, IsEqual.equalTo("line-through"));

        Assert.assertThat(detailsPageProductSalePriceColor, IsEqual.equalTo("rgba(204, 0, 0, 1)"));
        Assert.assertThat(detailsPageProductSalePriceFontSize, IsEqual.equalTo("22px"));
        Assert.assertThat(detailsPageProductSalePriceFontStyle, IsEqual.equalTo("bold"));
    }
}
