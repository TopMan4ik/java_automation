import org.testng.annotations.Test;

/**
 * Created by get on 22-Mar-16.
 */


public class QaEngineer {


    @Test
    public void tryUserInit() {
        Employee JohnnyDepp = new Employee("Jack", "Sparrow", "BlackPearl");
        Person person = new Person("Petr", "Mazepa");

        JohnnyDepp.displayInfo();
        person.displayInfo();
    }

}
