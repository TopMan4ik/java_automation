package kismia.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gef on 25-Mar-16.
 *
 * 1. Написать тесты на kismia.com (Settings , Profile test , etc ..)
 * 2. Документация TestNG  http://testng.org/doc/index.html
 * 3. @DataProvider TestNG
 * 4. Колекции
 */


public class LoginRegisterTest extends BrowserFactory {

    @Test
    public void loginOldUserTest() {
        MainPage_Lesson7_25_03_16 mainPage = new MainPage_Lesson7_25_03_16(driver);
        CommonMethods cm = new CommonMethods(driver);
        cm.openPage(mainPage.URL);
        cm.fillInInput(mainPage.EMAIL_FIELD, mainPage.USER_EMAIL);
        cm.fillInInput(mainPage.PASSWORD_FIELD, mainPage.USER_PASSWORD);
        driver.findElement(mainPage.LOGIN_BUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='nav']/ul/li[2]/a")).isDisplayed());
    }

    @Test
    public void loginOldUserNegativeTest() {
        MainPage_Lesson7_25_03_16 mainPage = new MainPage_Lesson7_25_03_16(driver);
        CommonMethods cm = new CommonMethods(driver);
        cm.openPage(mainPage.URL);
        cm.fillInInput(mainPage.EMAIL_FIELD, mainPage.USER_EMAIL);
        cm.fillInInput(mainPage.PASSWORD_FIELD, "hello-hello");
        driver.findElement(mainPage.LOGIN_BUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(@class, 'error-msg')]/a")).isDisplayed());
    }

    @Test
    public void registerNewUserTest() {
        MainPage_Lesson7_25_03_16 mainPage = new MainPage_Lesson7_25_03_16(driver);
        driver.get(mainPage.URL);
        mainPage.registerNewUserNoTest();
        Assert.assertTrue(driver.getCurrentUrl().equals("https://kismia.com/test"));
    }


}
