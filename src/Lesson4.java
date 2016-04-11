import org.testng.annotations.Test;


public class Lesson4 {

    @Test
    public void blaBla() {
        int sec = 3;
        for (int i = 0; i < 10; i++, sec *= 2) {
            System.out.print(i + " ");
            System.out.println(sec);
        }
    }

    boolean isValidInteger = true;

    @Test
    public void tryIf() {
        if (isValidInteger) {
            System.out.println("OK");
        }
    }




}