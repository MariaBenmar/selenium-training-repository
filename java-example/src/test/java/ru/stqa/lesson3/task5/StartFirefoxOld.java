package ru.stqa.lesson3.task5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

/**
 * Created by Maria on 12/23/2016.
 */
public class StartFirefoxOld {
    private WebDriver driverFf;
    private WebDriverWait waitFf;


    @Before
    public void start(){
        DesiredCapabilities caps = new DesiredCapabilities();
 //       caps.setCapability(FirefoxDriver.MARIONETTE, false);
         driverFf = new FirefoxDriver(new FirefoxBinary(new File("D:\\Tools\\Mozilla Firefox 45\\firefox.exe")), new FirefoxProfile(), caps);
//           driverFf = new FirefoxDriver();
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

}


