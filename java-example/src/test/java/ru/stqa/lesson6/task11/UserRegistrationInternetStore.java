package ru.stqa.lesson6.task11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.basetest.BaseTest;

/**
 * Created by Lenovo on 14.01.2017.
 */
public class UserRegistrationInternetStore extends BaseTest{
    String locatorTaxId, locatorCompany, locatorFirstName, locatorLastName, locatorAddrLine1, locatorAddrLine2,
            locatorPostcode, locatorCity, locatorCountryCode, locatorZoneCode, locatorEmail, locatorPhone,
            locatorNewsletter, locatorPassword, locatorConfirmPassword, locatorCreateAccountButton,
             locatorLogoutLink, locatorNewCustomerLink,locatorLoginButton;
    String textTaxId, textCompany, textFirstName, textLastName, textAddrLine1, textAddrLine2,
            textPostcode, textCity, textCountryCode, textZoneCode, textEmail, textPhone,
             textPassword, textConfirmPassword;
    WebElement createAccountButton, logoutLink, newCustomerLink, loginButton;

    public void fillText(String text, String locatorSearch){
        WebElement locator = driver.findElement(By.cssSelector(locatorSearch));
        locator.clear();
        locator.sendKeys(text);
    }

    public void fillSelectForm(String code, String locatorSearch){
        Select menuItem = new Select(driver.findElement(By.cssSelector(locatorSearch)));
        menuItem.selectByValue(code);
    }

    @Test
    public void userRegistrationInternetStore(){
        driver.navigate().to("http://localhost/litecart/en/");


    locatorTaxId = "input[name='tax_id']";
    locatorCompany = "input[name='company']";
    locatorFirstName = "input[name='firstname']";
    locatorLastName = "input[name='lastname']";
    locatorAddrLine1 = "input[name='address1']";
    locatorAddrLine2 = "input[name='address2']";
    locatorPostcode = "input[name='postcode']";
    locatorCity = "input[name='city']";
    locatorCountryCode = "select[name='country_code']";
    locatorZoneCode = "input[name='zone_code']";
    locatorEmail = "input[name='email']";
    locatorPhone = "input[name='phone']";
    locatorNewsletter = "input[name='newsletter']";
    locatorPassword = "input[name='password']";
    locatorConfirmPassword = "input[name='confirmed_password']";

    locatorCreateAccountButton = "button[name='create_account']";
    locatorLogoutLink = "#box-account > div > ul > li:nth-child(4) > a";
    locatorNewCustomerLink ="#box-account-login > div > form > table > tbody > tr:nth-child(5) > td > a";
    locatorLoginButton = "button[name = 'login']";

    // new account data
    textTaxId = "1234";
    textCompany = "SoftTest";
    textFirstName = "Marra";
    textLastName = "BenMart";
    textAddrLine1 = "AddrLine1";
    textAddrLine2 = "AddrLine2";
    textPostcode = "190185";
    textCity = "Spb";
    textCountryCode = "RU";
    textEmail = "mariabm+1@domain.com";
    textPhone = "+71234567890";
    textPassword = "Qwerty_1234";
    textConfirmPassword = "Qwerty_1234";

    newCustomerLink = driver.findElement(By.cssSelector(locatorNewCustomerLink));
    newCustomerLink.click();
    fillText (textTaxId, locatorTaxId);
    fillText (textCompany, locatorCompany);
    fillText (textFirstName, locatorFirstName);
    fillText (textLastName, locatorLastName);
    fillText (textAddrLine1, locatorAddrLine1);
    fillText (textAddrLine2, locatorAddrLine2);
    fillText (textPostcode, locatorPostcode);
    fillText (textCity, locatorCity);
    fillSelectForm (textCountryCode, locatorCountryCode);
    fillText (textEmail, locatorEmail);
    fillText (textPhone, locatorPhone);
    fillText (textPassword, locatorPassword);
    fillText (textConfirmPassword, locatorConfirmPassword);

    createAccountButton = driver.findElement(By.cssSelector(locatorCreateAccountButton));
        createAccountButton.click();

    logoutLink = driver.findElement(By.cssSelector(locatorLogoutLink));
        logoutLink.click();
    fillText (textEmail, locatorEmail);
    fillText (textPassword, locatorPassword);

    loginButton = driver.findElement(By.cssSelector(locatorLoginButton));
        loginButton.click();

    logoutLink = driver.findElement(By.cssSelector(locatorLogoutLink));
        logoutLink.click();
    }
}
