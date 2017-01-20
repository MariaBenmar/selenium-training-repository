package ru.stqa.lesson6.task12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;

/**
 * Created by Lenovo on 15.01.2017.
 */
public class AddNewProductAdminPage extends BaseTest{
    private WebElement  usernameAdminPage, passwordAdminPage, loginButton, addNewProductButton, generalTab, name, code,
            quantity, quantityUnit,deliveryStatus, soldOutStatus, dateValidFrom, dateValidTo;
    private String locatorUsername, locatorPassword, locatorLoginButton, locatorMenuItemsList ,locatorSubMenuItemsList,
            locatorAddNewProductButton, locatorGeneralTab, locatorEnabledStatusRadioButton, locatorName, locatorCode,
            locatorCategories, locatorDefaultCategory, locatorProductGroups,locatorQuantity, locatorQuantityUnit,
            locatorDeliveryStatus, locatorSoldOutStatus, locatorUploadImage, locatorDateValidFrom, locatorDateValidTo,
            locatorProductCatalogNames;

    private String productName, productCode;

    private List<WebElement> mainMenuItems,  menuItemNames,statusRadioButton, categories, defaultCategory,
            productGroups, uploadImages, productCatalogNames;


    @Test
    public void addNewProductAdminPage() {
        loginToAdmin();
        //locators
        locatorMenuItemsList = "#app-";
        locatorSubMenuItemsList = "a";
        locatorAddNewProductButton = "#content a.button:nth-child(2)";
        locatorGeneralTab = "#content .index li:nth-child(1) a";
        locatorEnabledStatusRadioButton = "#tab-general label:nth-child(3) input[type='radio']";
        locatorName = "input[name = 'name[en]']";
        locatorCode = "input[name = 'code']";
        locatorCategories = "input[name = 'categories[]']";
        locatorDefaultCategory = "select[name = 'default_category_id']";

        locatorProductGroups = "#tab-general tr:nth-child(7) div.input-wrapper tr td";
        locatorQuantity = "//input[@name = 'quantity']";
        locatorQuantityUnit = "//select[@name = 'quantity_unit_id']";
        locatorDeliveryStatus = "//select[@name = 'delivery_status_id']";
        locatorSoldOutStatus = "//select[@name = 'sold_out_status_id']";
        locatorUploadImage = "//input[@name = 'new_images[]']";
        locatorDateValidFrom = "//input[@name = 'date_valid_from']";
        locatorDateValidTo = "//input[@name = 'date_valid_to']";
        locatorProductCatalogNames = "//tr[@class = 'row']//td[3]//a";

        //Add product data
        productName = "new Maria Product";
        productCode = "Product Code 10";


        mainMenuItems = driver.findElements(By.cssSelector(locatorMenuItemsList));
        mainMenuItems.get(1).findElement(By.cssSelector(locatorSubMenuItemsList)).click();
        clickElementByLocator(locatorAddNewProductButton);
        clickElementByLocator(locatorGeneralTab);
        clickElementByLocator(locatorEnabledStatusRadioButton);
        fillText(locatorName,productName);
        fillText(locatorCode,productCode);



        setElementByName("Rubber Ducks", locatorCategories, "data-name");
        fillSelectForm("Root",locatorDefaultCategory);
        setElementByName("Female", locatorProductGroups, "outerText");




    }
}


