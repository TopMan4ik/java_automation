import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

    /**
     * This is the constructor to create class instance with 2 variables we need
     * @param driver WebDriver
     */
    public Game2048(WebDriver driver) {
        this.driver = driver;
        this.url = "http://gabrielecirulli.github.io/2048/";
    }

    String url;
    PrintWriter writer;

    By scoreContainer = By.xpath("//div[@class='score-container']");
    By tileContainer = By.xpath("//div[@class='tile-container']/div");
    By gameOver = By.xpath("//div[@class='game-message game-over']");

    @Override
    public void setUp() {
        setUp(driver);
    }

    public void setUp(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Override
    public void tearDown() {
        writer.close();
        driver.close();
        driver.quit();
    }

    public void openPage() {
        driver.get(url);
        driver.findElement(scoreContainer).click(); //It's needed for firefox to focus page
    }

    public void playTheGame() {
        int stepsCounter = 0;
        while (!isElementPresent(gameOver)) {//it'll be good to change this check
            String[][] gameField = getFieldState();
            printFieldState(gameField, stepsCounter);
            doRandomActionUsingWebDriver(getRandomInt(1,4));
            stepsCounter++;
        }
    }

    public void doRandomActionUsingWebDriver(int choice) {
        Actions builder = new Actions(driver);
        switch (choice) {
            case 1: builder.sendKeys(Keys.DOWN).build().perform(); break;
            case 2: builder.sendKeys(Keys.UP).build().perform(); break;
            case 3: builder.sendKeys(Keys.LEFT).build().perform(); break;
            case 4: builder.sendKeys(Keys.RIGHT).build().perform(); break;
        }
        sleep(200); //Every step needs some time to wait because of animations
    }

    public String[][] getFieldState() {
        List<WebElement> tiles = driver.findElements(tileContainer);
        String[][] gameField = new String[4][4];
        for (WebElement tile : tiles) {
            int lastIndex = tile.getAttribute("class").indexOf("tile-position-");
            String x = tile.getAttribute("class").substring(lastIndex+14, lastIndex+15);
            String y = tile.getAttribute("class").substring(lastIndex+16, lastIndex+17);
            int coordinateX = Integer.valueOf(x)-1;
            int coordinateY = Integer.valueOf(y)-1;
            gameField[coordinateY][coordinateX] = tile.getText();
        }
        return gameField;
    }

    public void printFieldState(String[][] gameField, int stepNumber) {
        out("\nStep " + stepNumber + ":", true);
        for (String[] row : gameField) {
            for (String tile : row){
                if (tile == null)
                    out("| 0 ", false);
                else
                    out("| " + tile + " ", false);
            }
            out("|", true);
        }
    }

    public void printScore(){
        out("Final score is: " + driver.findElement(scoreContainer).getText(), true);
    }

    public void initializeWriter() throws FileNotFoundException, UnsupportedEncodingException {
        this.writer = new PrintWriter("scores.txt", "UTF-8");
    }

    public void out(String message, boolean newLine){
        if (newLine) {
            System.out.println(message);
            writer.println(message);
        } else {
            System.out.print(message);
            writer.print(message);
        }
    }

}
