package ru.stqa.lesson6.task12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 15.01.2017.
 */
public class AddNewProductAdminPage extends BaseTest{

    private String    locatorMenuItemsList ,locatorSubMenuItemsList,locatorAddNewProductButton, locatorProductNames,
            locatorGeneralTab, locatorInfoTab, locatorPriceTab,productName, locatorEnabledStatusRadioButton, locatorName,
            locatorCode, locatorCategories, locatorDefaultCategory, locatorProductGroups, locatorQuantity, locatorUploadImage,
            locatorDateValidFrom, locatorDateValidTo, locatorManufacturer, locatorKeywords,locatorShortDescription,
            locatorLongDescription, locatorHeadTitle, locatorMetaDescr, locatorPurchasePrice, locatorCurrCode,
            locatorPriceUSD,locatorSaveButton;

    private List<WebElement> mainMenuItems;

    public Boolean isProductNamePresentInCatalog(String name, String locator){
        List<WebElement> Products = driver.findElements(By.cssSelector(locator));
        Boolean result = false;
        for (WebElement product : Products){
            if (name.equals(product.getText())){
                result = true;
            }
        }
        return result;
    }

    @Test
    public void addNewProductAdminPage() {
        loginToAdmin();
        //locators
        locatorMenuItemsList = "#app-";
        locatorSubMenuItemsList = "a";
        locatorAddNewProductButton = "#content a.button:nth-child(2)";
        locatorProductNames = ".dataTable tr td a";

        locatorGeneralTab = "[href='#tab-general']";
        locatorEnabledStatusRadioButton = "#tab-general label:nth-child(3) input[type='radio']";
        locatorName = "input[name = 'name[en]']";
        locatorCode = "input[name = 'code']";
        locatorCategories = "input[name = 'categories[]']";
        locatorDefaultCategory = "select[name = 'default_category_id']";
        locatorProductGroups = "#tab-general tr:nth-child(7) div.input-wrapper tr td";
        locatorQuantity = "input[name = 'quantity']";
        locatorUploadImage = "input[name = 'new_images[]']";
        locatorDateValidFrom = "input[name = 'date_valid_from']";
        locatorDateValidTo = "input[name = 'date_valid_to']";

        locatorInfoTab = "[href='#tab-information']";
        locatorManufacturer = "[name='manufacturer_id']";
        locatorKeywords = "[name='keywords']";
        locatorShortDescription = "[name='short_description[en]']";
        locatorLongDescription = "[name='description[en]']";
        locatorHeadTitle = "[name='head_title[en]']";
        locatorMetaDescr = "[name='meta_description[en]']";

        locatorPriceTab = "[href='#tab-prices']";
        locatorPurchasePrice = "[name='purchase_price']";
        locatorCurrCode = "[name='purchase_price_currency_code']";
        locatorPriceUSD = "[name='prices[USD]']";

        locatorSaveButton = "[name='save']";
        productName = "new Maria Product";


        mainMenuItems = driver.findElements(By.cssSelector(locatorMenuItemsList));
        mainMenuItems.get(1).findElement(By.cssSelector(locatorSubMenuItemsList)).click();

        Assert.assertFalse("Error: Product is created too", isProductNamePresentInCatalog(productName , locatorProductNames));

        clickElementByLocator(locatorAddNewProductButton);
        clickElementByLocator(locatorGeneralTab);
        clickElementByLocator(locatorEnabledStatusRadioButton);
        fillText(productName,locatorName);
        fillText("Code 10",locatorCode);
        setElementByName("Rubber Ducks", locatorCategories, "data-name");
        setElementByName("Female", locatorProductGroups, "outerText");
        fillText("250",locatorQuantity);
        fillText("C:\\Users\\Lenovo\\Pictures\\test.jpg",locatorUploadImage);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        setText("01.02.2017",locatorDateValidFrom);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        setText("01.11.2017",locatorDateValidTo);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        clickElementByLocator(locatorInfoTab);
        fillSelectVisibleForm("ACME Corp.", locatorManufacturer);
        fillText("lorem test",locatorKeywords);
        fillText("test description",locatorShortDescription);
        fillText("test longlonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglong  description",locatorLongDescription);
        fillText("test head title",locatorHeadTitle);
        fillText("test meta descr",locatorMetaDescr);

        clickElementByLocator(locatorPriceTab);
        fillText("30.9",locatorPurchasePrice);
        fillSelectForm("USD", locatorCurrCode);
        fillText("22.3",locatorPriceUSD);

        clickElementByLocator(locatorSaveButton);

        mainMenuItems = driver.findElements(By.cssSelector(locatorMenuItemsList));
        mainMenuItems.get(1).findElement(By.cssSelector(locatorSubMenuItemsList)).click();

        Assert.assertTrue("Product is not found", isProductNamePresentInCatalog(productName , locatorProductNames));
    }
}


