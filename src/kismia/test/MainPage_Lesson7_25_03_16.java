package kismia.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gef on 25-Mar-16.
 */


public class MainPage_Lesson7_25_03_16 {

    private static WebDriver driver;


    MainPage_Lesson7_25_03_16(WebDriver driver) {
        this.driver = driver;
        this.URL = "https://kismia.com/";
    }


    public String URL = "https://kismia.com/";

    public String USER_EMAIL = "pavel.bunyaner.81@mail.ru"; //CSN98HL1B
    public String USER_PASSWORD = "prosto555";

    public By EMAIL_FIELD = By.xpath("//input[@id='user-email']");
    public By PASSWORD_FIELD = By.xpath("//input[@id='user-password']");
    public By LOGIN_BUTTON = By.xpath("//button[@class='submit']");
    public By REGISTRATION_TAB = By.xpath("//li[@id='form-registration']");
    public By I_AM_BOY = By.xpath("//label[@for='iam-boy']");
    public By I_AM_GIRL = By.xpath("//label[@for='iam-girl']");
    public By NAME_FIELD = By.xpath("//input[@id='user-reg-myname']");
    public By CONTINUE_BUTTON = By.xpath("//div[@id='block-first']/button");
    public By REGISTRATION_EMAIL_FIELD = By.xpath("//div[@id='block-first']/button");
    public By REGISTRATION_PASSWORD_FIELD = By.xpath("//div[@id='block-first']/button");
    public By LAST_BUTTON = By.xpath("//div[@id='block-last']/button");


    public void login(String email, String password) {
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void registerNewUserNoTest() {

    }



}
