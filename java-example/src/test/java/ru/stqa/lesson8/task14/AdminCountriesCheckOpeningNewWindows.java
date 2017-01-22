package ru.stqa.lesson8.task14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.basetest.BaseTest;

import java.util.List;

/**
 * Created by Lenovo on 23.01.2017.
 */
public class AdminCountriesCheckOpeningNewWindows extends BaseTest{

        private String locatorMainMenuCountries, locatorAddNewCountryButton, locatorExternalLink;
        private List<WebElement> externalLinksList;

    @Test
    public void adminCountriesCheckOpeningNewWindows(){

        locatorMainMenuCountries ="td#sidebar li#app-:nth-child(3) a";
        locatorAddNewCountryButton = "div[style='float: right;'] a";
        locatorExternalLink = "a[target = '_blank'] i.fa.fa-external-link";
        loginToAdmin();

        WebElement mainMenuItemCountries = driver.findElement(By.cssSelector(locatorMainMenuCountries));
        mainMenuItemCountries.click();
        clickElementByLocator(locatorAddNewCountryButton);
        externalLinksList = driver.findElements(By.cssSelector(locatorExternalLink));

        for (Integer i = 0; i < externalLinksList.size(); i++){
            WebElement externalLink = externalLinksList.get(i);
            switchToNewWindowCloseAndReturn(externalLink);
        }
    }
}
