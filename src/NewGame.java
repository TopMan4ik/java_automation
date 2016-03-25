import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

/**
 * Created by gef on 3/22/2016.
 */


public class NewGame {

    static WebDriver driver;
    
    public static void main(String[] args) {
        Game2048 game = new Game2048(selectBrowser());
        game.setUp();
        game.openPage();
        game.playTheGame();
        game.printScore();
        game.tearDown();
    }

    public static WebDriver selectBrowser() {
        System.out.print("Choose browser: 1-chrome, 2-firefox: ");
        Scanner in = new Scanner(System.in);
        String browser = in.nextLine();
        if (browser.equals("1")) {
            return driver = new ChromeDriver();
        } else if (browser.equals("2")) {
            return driver = new FirefoxDriver();
        } else {
            return driver = new ChromeDriver();
        }
    }
}
