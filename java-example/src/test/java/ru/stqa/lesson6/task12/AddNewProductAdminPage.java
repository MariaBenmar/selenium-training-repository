package ru.stqa.lesson6.task12;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;

/**
 * Created by Lenovo on 15.01.2017.
 */
public class AddNewProductAdminPage extends BaseTest{
    private WebElement usernameAdminPage, passwordAdminPage, loginButton, addNewProductButton, generalTab, name, code,
            quantity, quantityUnit,deliveryStatus, soldOutStatus, dateValidFrom, dateValidTo;
    private String locatorUsername, locatorPassword, locatorLoginButton, locatorMenuItemsList, locatorMenuItemNamesList ,
            locatorAddNewProductButton, locatorGeneralTab, locatorStatusRadioButton, locatorName, locatorCode,
            locatorCategories, locatorDefaultCategory, locatorProductGroups,locatorQuantity, locatorQuantityUnit,
            locatorDeliveryStatus, locatorSoldOutStatus, locatorUploadImage, locatorDateValidFrom, locatorDateValidTo,
            locatorProductCatalogNames;

    private List<WebElement> menuItems, menuItemNames,statusRadioButton, categories, defaultCategory,
            productGroups, uploadImages, productCatalogNames;


    @Test
    public void addNewProductAdminPage() {
        loginToAdmin();
        locatorUsername = "username";
        locatorPassword = "password";
        locatorLoginButton = "login";
        locatorMenuItemsList = "#app-";
        locatorMenuItemNamesList = "#app- a";
        locatorAddNewProductButton = "a.button text() = ' Add New Product'";
        locatorGeneralTab = "//div[@class = 'tabs']//a[text()='General']";
        locatorStatusRadioButton = "input[@name = 'status']";
        locatorName = "//input[@name = 'name[en]']";
        locatorCode = "//input[@name = 'code']";
        locatorCategories = "//input[@name = 'categories[]']";
        locatorDefaultCategory = "//select[@name = 'default_category_id']";
        locatorProductGroups = "//input[@name = 'product_groups[]']";
        locatorQuantity = "//input[@name = 'quantity']";
        locatorQuantityUnit = "//select[@name = 'quantity_unit_id']";
        locatorDeliveryStatus = "//select[@name = 'delivery_status_id']";
        locatorSoldOutStatus = "//select[@name = 'sold_out_status_id']";
        locatorUploadImage = "//input[@name = 'new_images[]']";
        locatorDateValidFrom = "//input[@name = 'date_valid_from']";
        locatorDateValidTo = "//input[@name = 'date_valid_to']";
        locatorProductCatalogNames = "//tr[@class = 'row']//td[3]//a";






    }
}


