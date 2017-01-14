package ru.stqa.lesson6.task11;

import org.junit.Test;
import ru.stqa.basetest.BaseTest;

/**
 * Created by Lenovo on 14.01.2017.
 */
public class UserRegistrationInternetStore extends BaseTest{

    @Test
    public void userRegistrationInternetStore(){
        driver.navigate().to("http://localhost/litecart/en/");
    }

}
