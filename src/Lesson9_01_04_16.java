import java.util.*;

/**
 * Created by svistik on 01-Apr-16.
 */


public class Lesson9_01_04_16 {

    /*
    List - коллекция с индексированными элементами
    Set - множество элементов
    Map - множество пар
     */

    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();
        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        removeCats(pets, cats);
        printPets(pets);
    }

    /* Множество всех животных
    1. Внутри класса Solution создать public static классы Cat, Dog.
    2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
    3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
    4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
    5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
    6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
    */

    public static class Cat {
    }

    public static class Dog {
    }

    public static Set<Cat> createCats() {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Set<Cat> set = new HashSet<>();
        set.add(cat1);
        set.add(cat2);
        set.add(cat3);
        set.add(cat4);
        return set;
    }

    public static Set<Dog> createDogs() {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Set<Dog> set = new HashSet<>();
        set.add(dog1);
        set.add(dog2);
        set.add(dog3);
        return set;
    }

    public static Set<Object> join (Set <Cat> cats, Set <Dog> dogs) {
        Set<Object> set = new HashSet<>();
        set.add(cats);
        set.add(dogs);
        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //foreach is not suitable to remove elements from collection
        Iterator<Object> iterator = pets.iterator();
        while ( iterator.hasNext() ) {
            if (iterator.next() == cats)
                iterator.remove();
        }
    }

    public static void printPets(Set<Object> pets) {
        for (Object pet : pets) {
            System.out.println(pet);
        }
    }

}
