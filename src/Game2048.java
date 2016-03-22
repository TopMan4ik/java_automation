import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by gef on 3/22/2016.
 */


      /*
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

public class Game2048 {

    public Game2048(WebDriver driver, String url) {
        this.driver = driver;
        this.URL = url;
    }

    WebDriver driver;
    String URL = "http://gabrielecirulli.github.io/2048/";
    By NEW_GAME_XPATH = By.xpath("//a[@class='restart-button']");
    By SCORE_XPATH = By.xpath("//div[@class='scores-container']");
    By BEST_SCORE_XPATH = By.xpath("//div[@class='best-container']");

    public void performRandomAction() {

    }

    public void printBrowser() {

    }


}
