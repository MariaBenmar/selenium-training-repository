package ru.stqa.lesson3.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Maria on 12/23/2016.
 */
public class StartFireFox {
    private WebDriver driverFf;
    private WebDriverWait waitFf;


    @Before
    public void start(){
/*        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, true);
        WebDriver driver = new FirefoxDriver(caps);*/
        driverFf = new FirefoxDriver();
        System.out.println(((HasCapabilities) driverFf).getCapabilities());
        waitFf = new WebDriverWait(driverFf, 10);
    }



    @Test
    public void startChrome(){

    }



    @After
    public void stop(){
        driverFf.quit();
        driverFf = null;
    }



    /*
        */
}
