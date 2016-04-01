import org.testng.annotations.Test;

/**
 * Created by gef on 22-Mar-16.
 */


public class Lesson6_22_03_16 extends TestHarness {

    public Lesson6_22_03_16(){} //это и есть конструктор, пустой, неопределенный для данного класса

    /*
    конструкторы для создания экземпляра класса и инициализации его переменных
    конструктор это метод класса, с таким же названием, выполняется при инициализации класса
     */

    public String name;
    public int age;
    public String email;
    public String password;

    //User user1 = new User("asdasd@gmail.com", "password123"); когда есть конструктор, можно делать так (не в методе)

    @Test
    public void userInit() {
        User user1 = new User("asdasd@gmail.com", "password123");
        User user2 = new User("qweqwe@gmail.com", "password231");
        User user3 = new User("zxczxc@gmail.com", "password321");
        User user4 = new User("name12", "zxczxc@gmail.com", "password321", 32);

        System.out.println("Usr1: " + user1.email + " password: " + user1.password);
        System.out.println("Usr1: " + user2.email + " password: " + user2.password);
        System.out.println("Usr1: " + user3.email + " password: " + user3.password);
    }

    //getters, setters - получают или назначают переменные
    //читать про конструкторы, геттеры, сеттеры, this

    //наследование в джаве только от 1-го класса
    //от класса нельзя наследоваться если он final, от метода нельзя...

    /**
     * создать класс на домашней странице kismia.com
     * потом наследоваться от домашней на другую и допилить функционала kismia.com/support
     */


}

