package kismia.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gef on 3/30/2016.
 */


public class CommonMethods {

    public WebDriver driver;

    public void openPage(String url){
        driver.get(url);
    }

    /**
     * This method fills input field with value
     * @param locator By
     * @param value String
     */
    public void fillInInput(By locator, String value){
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    /**
     *
     * @return String
     */
    public String getNewEmail(){
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return "test" + dateFormat.format(date) + "@mail.ru";
    }

    /**
     * Stops running for some time in milliseconds
     * @param timeInMilliseconds int
     */
    public void sleep(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException ex) {
            System.out.println("Thread Sleep Exception! " + ex);
        }
    }
}
