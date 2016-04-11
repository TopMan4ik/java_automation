import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by gef
 */


public class TestHarness {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    /**
     * Opens page
     * @param url String
     */
    public void openPage(String url) {
        driver.get(url);
        //TODO: Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }

    /**
     * This method generates and returns emails
     * @return String
     */
    public String generateEmail() {
        DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        Date date = new Date();
        return "test" + dateFormat.format(date) + "@mail.ru";
    }

    /**
     * This method returns random int in range between min and max including them
     * @param min int
     * @param max int
     * @return int
     */
    public int getRandomInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    /**
     * This method returns random int in range between 1 and 10 including them
     * @return int
     */
    public int getRandomInt() {
        return getRandomInt(1,10);
    }

    public void selectValueInDropDown(By locator, String value) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
        Select DropDown = new Select(driver.findElement(locator));
        DropDown.selectByVisibleText(value);
    }

    public void checkCheckbox(By locator) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
        WebElement targetCheckbox = driver.findElement(locator);
        if (targetCheckbox.isSelected()) {
            System.out.println("Checkbox is already checked");
        } else {
            targetCheckbox.click();
        }
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

    public boolean isTextPresentOnPage(String text) {
        List<WebElement> list = driver.findElements( By.xpath("//*[contains(text(),'" + text + "')]") );
            return (list.size() > 0);
        }

    /**
     * This method is waiting during specified time till the element will be present on the current page.
     *
     * @param by               Locator of the element on page, which have type By.
     * @param timeOutInSeconds int Time(seconds) for waiting of the element
     */
    public void waitForElementIsPresent(By by, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Returns true if element is present on page
     * @param by By
     * @return boolean
     */
    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }
}
