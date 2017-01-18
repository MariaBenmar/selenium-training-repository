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
            locatorAcceptCookiesButton, locatorLogoutLink, locatorNewCustomerLink,locatorLoginButton;
    String textTaxId, textCompany, textFirstName, textLastName, textAddrLine1, textAddrLine2,
            textPostcode, textCity, textCountryCode, textZoneCode, textEmail, textPhone,
            textNewsletter, textPassword, textConfirmPassword;
    WebElement taxId, company, firstName, lastName, addrLine1, addrLine2, postcode, city, countryCode, zoneCode,
            email, phone, newsletter, password, confirmPassword, createAccountButton,
            logoutLink, newCustomerLink, loginButton;

    public void fillText(String text, WebElement locator){
        locator.clear();
        locator.sendKeys(text);
    }

    public void fillSelectForm(String code, WebElement locator){
        Select menuItem = new Select(locator);
        menuItem.selectByValue(code);
    }

    @Test
    public void userRegistrationInternetStore(){
        driver.navigate().to("http://localhost/litecart/en/");
    }

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
    locatorAcceptCookiesButton = "input[name='accept_cookies']";

    locatorLogoutLink = "//div[@id = 'box-account']//div[@class = 'content']//a[text()='Logout']";

    locatorNewCustomerLink ="/*//*[@id='box-account-login']//a[text()='New customers click here']";
    locatorLoginButton = "button[name = 'login']";

    // new account data
    textTaxId = "1234";
    textCompany = "SoftTest";
    textFirstName = "Marra";
    textLastName = "BenMart";
    textAddrLine1 = "AddrLine1";
    textAddrLine2 = "AddrLine2";
    textZoneCode = "190185";
    textCity = "Spb";
    textCountryCode = "UA";
    textEmail = "mariabm@domain.com";
    textPhone = "+71234567890";
    textPassword = "Qwerty_1234";
    textConfirmPassword = "Qwerty_1234";

    newCustomerLink = driver.findElement(By.cssSelector(locatorNewCustomerLink));
        newCustomerLink.click();
    taxId = driver.findElement(By.cssSelector(locatorTaxId));
    fillText (textTaxId, taxId);
    company = driver.findElement(By.cssSelector(locatorCompany));
    fillText (textCompany, company);
    firstName = driver.findElement(By.cssSelector(locatorFirstName));
    fillText (textFirstName, firstName);
    lastName = driver.findElement(By.cssSelector(locatorLastName));
    fillText (textLastName, lastName);
    addrLine1 = driver.findElement(By.cssSelector(locatorAddrLine1));
    fillText (textAddrLine1, addrLine1);
    addrLine2 = driver.findElement(By.cssSelector(locatorAddrLine2));
    fillText (textAddrLine2, addrLine2);
    zoneCode = driver.findElement(By.cssSelector(locatorZoneCode));
    fillText (textZoneCode, zoneCode);
    city = driver.findElement(By.cssSelector(locatorCity));
    fillText (textCity, city);
    countryCode = driver.findElement(By.cssSelector(locatorCountryCode));
    fillSelectForm (textCountryCode, countryCode);
//        Select country = new Select(Country);
//        country.selectByValue(code);
    email = driver.findElement(By.cssSelector(locatorEmail));
    fillText (textEmail, email);
    phone = driver.findElement(By.cssSelector(locatorPhone));
    fillText (textPhone, phone);
    password = driver.findElement(By.cssSelector(locatorPassword));
    fillText (textPassword, password);
    confirmPassword = driver.findElement(By.cssSelector(locatorConfirmPassword));
    fillText (textConfirmPassword, confirmPassword);
    createAccountButton = driver.findElement(By.cssSelector(locatorCreateAccountButton));
        createAccountButton.click();

    logoutLink = driver.findElement(By.cssSelector(locatorLogoutLink));
        logoutLink.click();
    email = driver.findElement(By.cssSelector(locatorEmail));
    fillText (textEmail, email);
    password = driver.findElement(By.cssSelector(locatorPassword));
    fillText (textPassword, password);

    loginButton = driver.findElement(By.cssSelector(locatorLoginButton));
        loginButton.click();

    logoutLink = driver.findElement(By.cssSelector(locatorLogoutLink));
        logoutLink.click();
}

}
