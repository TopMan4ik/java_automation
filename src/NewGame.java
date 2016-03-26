import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by gef on 3/22/2016.
 */


public class NewGame {

    static WebDriver driver;
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Game2048 game = new Game2048(selectBrowser());
        game.setUp();
        game.initializeWriter();
        game.openPage();
        game.playTheGame();
        game.printScore();
        game.tearDown();
    }

    public static WebDriver selectBrowser() {
        System.out.print("Choose browser: 1-chrome, 2-firefox: ");
        Scanner in = new Scanner(System.in);
        String browser = in.nextLine();
        switch (browser) {
            case "1": return driver = new ChromeDriver();
            case "2": return driver = new FirefoxDriver();
            default: return driver = new ChromeDriver();
        }
    }
}
