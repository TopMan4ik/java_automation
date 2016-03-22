import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

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

    public Game2048(String chosenDriver) {
        this.chosenDriver = chosenDriver;
        this.url = "http://gabrielecirulli.github.io/2048/";
    }

    String chosenDriver;
    WebDriver driver;
    String url;

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

    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public void openPage() {
        driver.get(url);
    }

    public void playTheGame() {

    }



}
