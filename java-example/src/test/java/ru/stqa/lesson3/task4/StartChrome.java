package ru.stqa.lesson3.task4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartChrome {

    private WebDriver driverChr;
    private WebDriverWait waitChr;


    @Before
    public void start() {
/*        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);*/
        driverChr = new ChromeDriver();
        System.out.println(((HasCapabilities) driverChr).getCapabilities());
        waitChr = new WebDriverWait(driverChr, 10);
    }


    @Test
    public void startChrome() {

    }


    @After
    public void stop() {
        driverChr.quit();
        driverChr = null;
    }
}
