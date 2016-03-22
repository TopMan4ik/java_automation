import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

/**
 * Created by gef on 18-Mar-16.
 */


public class Lesson5_18_03_16 extends TestHarness {

    @Test
    public void example() {

        String string1 = new String("Hello");
        String string2 = "Hello";

        boolean boo1 = string1 == string2;
        boolean boo2 = string1.equals(string2);

        System.out.println(boo1); //false
        System.out.println(boo2); //true
    }

    @Test
    public void example2() {
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.print("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Not sure");
        }
    }

    /*
    All about инкапсуляция
    privat - только из класса где объявлен
    protected - доступны для классов-потомков
    static - доступно без создания экземпляра метода
    */

    @Test
    public void hometask1() {
        //Даны 4 числа типа int. Сравнить их и вывести наименьшее на консоль.
        int qty = 4;
        int[] numbers = new int[qty];
        for (int i=0; i<qty; i++) {
            numbers[i] = getRandomInt(1,10);
            System.out.print( numbers[i] + " " );
        }
        int j = 0; int min = numbers[0]; int max = numbers[0];
        do {
            if (numbers[j+1] < min)
                min = numbers[j+1];
            if (numbers[j+1] > max)
                max = numbers[j+1];
            j++;
        } while (j<numbers.length-1);
        System.out.println( "Min number is: " + min );

        //Вывести на консоль количество максимальных чисел среди этих четырех.
        int maxQty = 0;
        for (int number : numbers) {
            if (number == max)
                maxQty++;
        }
        System.out.println( "Qty of max numbers is: " + maxQty );
    }

    @Test
    public void hometask2() {
        //Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.
        int qty = 6;
        int numbers[] = new int[qty];
        for (int i=0; i<qty; i++) {
            numbers[i] = getRandomInt(1,10);
            System.out.print( numbers[i] + " " );
        }
        int j = 1;
        int min = numbers[0]; int max = numbers[0];
        while (j < qty) {
            if (numbers[j] < min)
                min = numbers[j];
            if (numbers[j] > max)
                max = numbers[j];
            j++;
        }
        System.out.println( "Min is: " + min + ". Max is: " + max );
    }

    @Test
    public void hometask3() {
        //Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.
        String name1 = "Jack Cerouac";
        String name2 = "Jack Daniel";
        if (name1.equalsIgnoreCase(name2))
            System.out.println("These two guys are namesakes");
    }

    @Test
    public void hometask4() {
        //Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.
        int month = getRandomInt(1,12);
        System.out.print(month + " is ");
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println( "Winter" );
                break;
            case 3:
            case 4:
            case 5:
                System.out.print( "Spring" );
                break;
            case 6:
            case 7:
            case 8:
                System.out.println( "Summer" );
                break;
            case 9:
            case 10:
            case 11:
                System.out.println( "Autumn" );
                break;
            default:
                System.out.println( "Something goes wrong" );
        }
    }

    @Test
    public void multiplicationTable() {
        //а ну и зафигачте вывод на экран таблицы умножения
        for (int i=1; i<10; i++) {
            for (int j=1; j<10; j++) {
                if (i*j < 10)
                    System.out.print(i * j + "  ");
                else {
                    System.out.print(i * j + " ");
                }
            }
            System.out.println("");
        }
    }

    @Test
    public void liniaKinoTickets() {
        //Зайти на http://liniakino.com/showtimes/aladdin/
        //Открыть любой сеанс за 23 число мультик "Зоотрополис"
        //Вывести на экран 2 списка мест:
        //занятые места (ряд, место)
        //свободные места (ряд, место)
        //вывести цену за билет

        final By seance_xpath = By.xpath("//label[@class='date'][contains(text(), '23')]/following-sibling::div/ul/li[1]/a"); //first seance in list
        final By seats_xpath = By.xpath("//div[@id='hall-scheme-container']/div/div");
        final By prise = By.xpath("//div[@id='hall-scheme-legend']/ul/li[@class='seat-color1']");

        openPage("http://liniakino.com/showtimes/aladdin/");
        driver.findElement(seance_xpath).click();
        driver.switchTo().frame(0);
        waitForElementIsPresent(prise, 5);
        List<WebElement> seats = driver.findElements(seats_xpath);
        int seatRow = 0;
        for (WebElement seat : seats) {
            if (seat.getText().equals("1"))
                seatRow++;
            if (seat.getAttribute("class").contains("seat-color1"))
                System.out.println("Row " + seatRow + ": seat #" + seat.getText() + " is free");
            else if (seat.getAttribute("class").contains("seat-occupied"))
                System.out.println("Row " + seatRow + ": seat #" + seat.getText() + " is taken");
            else
                System.out.println("Row " + seatRow + ": seat #" + seat.getText() + " unknown");
        }
        System.out.println("\nTicket prise is " + driver.findElement(prise).getText());
    }


}
