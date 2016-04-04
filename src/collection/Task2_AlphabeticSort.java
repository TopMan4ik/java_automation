package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gef on 03-Apr-16.
 */

/*
Задача: Вводить с клавиатуры строки до тех пор пока не будет введена пустая строка,
после чего вывести строки в отсортированном порядке (алфавитном)
*/

public class Task2_AlphabeticSort {

    public static void main(String[] args) throws Exception {
        //заполните список строками при помощи reader.readLine();
        List<String> list = createList();
        //метод для сортировки списка
        sort(list);
        printList(list);
    }

    public static List<String> createList() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String str;
        do {
            System.out.print("Please, enter string: ");
            str = reader.readLine();
            if (str.equals("")) break;
            list.add(str);
        } while (true);
        return list;
    }

    public static void sort(List<String> list) {
        //реализуйте свой алгоритм сортировки списка при помощи  метода isGreaterThan(String a, String b)
        for (int j=1; j<list.size(); j++) {
            for (int i = 1; i < list.size(); i++) {
                if (isGreaterThan(list.get(i - 1), list.get(i))) {
                    String temp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, temp);
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    public static void printList(List<String> list){
        System.out.println("\nList: ");
        for (String str : list)
            System.out.println(str);
    }
}
