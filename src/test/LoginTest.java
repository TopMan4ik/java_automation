package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by svistik on 25-Mar-16.
 */


public class LoginTest extends BrowserFactory {

    @Test
    public void loginOldUserTest() {
        MainPage_Lesson7_25_03_16 mainPage = new MainPage_Lesson7_25_03_16(driver);
        driver.get("https://kismia.com");
        mainPage.login(mainPage.USER_EMAIL, mainPage.USER_PASSWORD);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/a")).isDisplayed());
    }
}
