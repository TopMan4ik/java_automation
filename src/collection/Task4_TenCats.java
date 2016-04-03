package collection;

import java.util.Map;
import java.util.Set;

/**
 * Created by gef on 03-Apr-16.
 */

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Task4_TenCats {

    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //Ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //Ваш код
    }

    public static void printCatSet(Set<Cat> set) {
        //Ваш код
    }

    public static class Cat {
        private String name;
        public Cat(String name) {
            this.name = name;
        }
        public String toString() {
            return "Cat "+this.name;
        }
    }

}
