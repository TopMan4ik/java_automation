import java.util.Scanner;

/**
 * Created by gef on 3/22/2016.
 */


public class NewGame {

    public static void main(String[] args) {

        Game2048 game = new Game2048(selectBrowser());
        game.setUp();
        game.openPage();
        game.playTheGame();
        game.tearDown();
    }


    public static String selectBrowser() {
        System.out.print("Choose browser: 1-chrome, 2-firefox: ");
        Scanner in = new Scanner(System.in);
        int browser = in.nextInt();
        if (browser == 1) {
            return "chrome";
        } else if (browser == 2) {
            return "firefox";
        } else
            return "undefined";
    }


}
