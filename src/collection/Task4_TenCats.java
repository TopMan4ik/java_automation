package collection;

import java.util.*;

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
        Map<String ,Cat> map = new LinkedHashMap<>();
        for (int i=0; i<10; i++) {
            Cat cat = new Cat("Kot-" + i);
            map.put("Cat" + i, cat);
        }
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            Cat value = pair.getValue();
            set.add(value);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        System.out.println("Cats: ");
        for (Cat cat : set)
            System.out.println(cat);
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
