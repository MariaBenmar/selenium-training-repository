package ru.stqa.lesson3.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartInternetExplorer {

    private WebDriver driverIe;
    private WebDriverWait waitIe;


    @Before
    public void start(){
 /*     DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        WebDriver driverIe = new InternetExplorerDriver(caps);*/
        driverIe = new InternetExplorerDriver();
        System.out.println(((HasCapabilities) driverIe).getCapabilities());
        waitIe = new WebDriverWait(driverIe, 10);
    }



    @Test
    public void startInternetExplorer(){

    }



    @After
    public void stop(){
        driverIe.quit();
        driverIe = null;
    }

}
