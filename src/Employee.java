/**
 * Created by gef on 22-Mar-16.
 */


public class Employee extends Person{

    private String company;

    public Employee(String name, String surname, String company) {
        super(name, surname); //super - ссылка на родителя
        this.company = company;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Company: " + company);
    }


}
