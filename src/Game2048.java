import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 Created by gef on 3/22/2016.

 Write a small application that automates the «2048 game»
 URL: http://gabrielecirulli.github.io/2048/
 Requirements:
 1. Bot is doing the random actions
 2. After each step, print current games field like:
 | 2 | 0 | 4 | 8 |
 | 2 | 0 | 4 | 8 |
 | 2 | 0 | 4 | 8 |
 | 4 | 8 | 32 | 16 |
 3. After the end of the game, print the current score
 4. You can run this against any browser of your choice
 Technologies and Practices :
 - Java
 - WebDriver
 Extra credit :
 - Modular code with OO design
 - Code comments / Java docs
 - Logging framework instead of System.out.println(), write log to file
 */

public class Game2048 extends TestHarness {

    public Game2048(String chosenDriver) {
        this.chosenDriver = chosenDriver;
        this.url = "http://gabrielecirulli.github.io/2048/";
    }

    String chosenDriver;
    WebDriver driver;
    String url;

    By scoreContainer = By.xpath("//div[@class='score-container']");

    @Override
    public void setUp () {
        setUp(chosenDriver);
    }

    public void setUp(String chosenDriver) {
        if (chosenDriver.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver();
        else if (chosenDriver.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            System.out.println("DRIVER WAS NOT DEFINED!");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Override
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void openPage() {
        driver.get(url);
    }

    public void playTheGame() {
        for (int stepsCounter = 0; stepsCounter <11; stepsCounter++) {
            doRandomAction(getRandomInt(1,4));
            printFieldState(stepsCounter);
            sleep (300);
        }
    }

    public void printScore(){
        System.out.println("Final score is: " + driver.findElement(scoreContainer).getText());
    }

    public void doRandomAction(int choice) {
        Actions builder = new Actions(driver);
        switch (choice) {
            case 1: builder.sendKeys(Keys.DOWN).build().perform();
                break;
            case 2: builder.sendKeys(Keys.UP).build().perform();
                break;
            case 3: builder.sendKeys(Keys.LEFT).build().perform();
                break;
            case 4: builder.sendKeys(Keys.RIGHT).build().perform();
                break;
        }
    }

    public void printFieldState(int stepNumber) {
        System.out.println("Step " + stepNumber + ":");
        List<WebElement> tiles = driver.findElements(By.xpath("//div[@class='tile-container']/div"));
        String[][] gameField = new String[4][4];
        for (WebElement tile : tiles) {
            int lastIndex = tile.getAttribute("class").indexOf("tile-position-");
            String x = tile.getAttribute("class").substring(lastIndex+14, lastIndex+15);
            int coordinateX = Integer.valueOf(x)-1;
            String y = tile.getAttribute("class").substring(lastIndex+16, lastIndex+17);
            int coordinateY = Integer.valueOf(y)-1;
            gameField[coordinateY][coordinateX] = tile.getText();
        }
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (gameField[i][j] == null)
                    System.out.print("| 0 ");
                else {
                    System.out.print("| " + gameField[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" ");
    }

}
