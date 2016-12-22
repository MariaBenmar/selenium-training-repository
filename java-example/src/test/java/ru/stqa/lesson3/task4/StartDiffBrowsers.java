package ru.stqa.lesson3.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maria on 12/22/2016.
 */
public class StartDiffBrowsers {

    private WebDriver driverChr, driverFf, driverIe;
    private WebDriverWait waitChr, waitFf, waitIe;


    @Before
    public void start(){
        driverChr = new ChromeDriver();
        waitChr = new WebDriverWait(driverChr, 10);
        driverFf = new FirefoxDriver();
        waitFf = new WebDriverWait(driverFf, 10);
        driverIe = new InternetExplorerDriver();
        waitIe = new WebDriverWait(driverIe, 10);


    }



    @Test



    @After
}
