package kismia.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by gef on 25-Mar-16.
 */


public class BrowserFactory {

    WebDriver driver;
    CommonMethods cm;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
