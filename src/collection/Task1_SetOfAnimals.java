package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gef on 4/1/2016.
 */


/* Множество всех животных
1. Внутри класса SetOfAnimals создать коллекции Cats и Dogs.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Task1_SetOfAnimals {

    public static void main(String[] args) {
        Set<String> cats = createCats();
        Set<String> dogs = createDogs();
        Set<String> pets = join(cats, dogs);
        printPets(pets);
        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<String> createCats() {
        Set<String> set = new HashSet<>();
        set.add("cat1");
        set.add("cat2");
        set.add("cat3");
        set.add("cat4");
        return set;
    }

    public static Set<String> createDogs() {
        Set<String> set = new HashSet<>();
        set.add("dog1");
        set.add("dog3");
        set.add("dog112");
        return set;
    }

    public static Set<String> join(Set<String> cats, Set<String> dogs) {
        Set<String> set = new HashSet<>();
        for (String cat : cats) {
            set.add(cat);
        }
        for (String dog : dogs) {
            set.add(dog);
        }
        return set;
    }

    public static void printPets(Set<String> pets) {
        System.out.println("\nList of pets:");
        for (String pet : pets)
            System.out.println(pet);
    }

    public static void removeCats(Set<String> pets, Set<String> cats) {
        Iterator<String> iterator = cats.iterator();
        while ( iterator.hasNext() ) {
            String entry = iterator.next();
            if (pets.contains(entry))
                pets.remove(entry);
        }
    }

}
