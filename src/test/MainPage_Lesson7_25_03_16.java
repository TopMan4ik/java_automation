package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by svistik on 25-Mar-16.
 */


public class MainPage_Lesson7_25_03_16 {

    MainPage_Lesson7_25_03_16(WebDriver driver) {
        this.driver = driver;
    }

    String USER_EMAIL = "pavel.bunyaner.81@mail.ru"; //CSN98HL1B
    String USER_PASSWORD = "prosto555";

    private By EMAIL_FIELD = By.xpath("//input[@id='user-email']");
    private By PASSWORD_FIELD = By.xpath("//input[@id='user-password']");
    private By LOGIN_BUTTON = By.xpath("//button[@class='submit']");
    private By REGISTRATION_TAB = By.xpath("//li[@id='form-registration']");
    private By I_AM_BOY = By.xpath("//label[@for='iam-boy']");
    private By I_AM_GIRL = By.xpath("//label[@for='iam-girl']");

    WebDriver driver;

    public void login(String email, String password){
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }




}
