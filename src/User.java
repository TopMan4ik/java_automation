/**
 * Created by gef on 22-Mar-16.
 */


public class User {

    public String name;
    public String email;
    public String password;
    public int age;


    /**
     * Constructor example method
     * @param email String
     * @param password String
     */
    public User (String email, String password) {
        this.email = email; //this это ссылка на текущий класс
        this.password = password;
    }

    public User (String name, String email, String password, int age) {
        //или this(email, password)
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    /**
     * Example of this
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter example
     * @return String
     */
    public String getUserEmail() {
        return email;
    }

}
