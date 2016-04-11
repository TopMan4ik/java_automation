package collection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by gef on 03-Apr-16.
 */

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Task5 {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.print("Please, enter string: ");
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sortSmart(array);
        printArray(array);
    }

    public static void sortSmart(String[] array) {
        String[] helper = new String[array.length];
        String[] numberArray = new String[array.length];
        String[] stringArray = new String[array.length];
        for (int i=0; i<array.length; i++){
            if ( isNumber(array[i]) ){
                helper[i] = "number";
                numberArray[i] = array[i];
                stringArray[i] = "";
            } else {
                helper[i] = "string";
                stringArray[i] = array[i];
                numberArray[i] = "";
            }
        }
        sortDirect(stringArray);
        sortReverse(numberArray);
        for (int i=0; i<array.length; i++) {
            if (helper[i].equals("number")) {
                array[i] = getFirstValue(numberArray);
            }
            else
                array[i] = getFirstValue(stringArray);
        }
    }

    public static void sortDirect(String[] array) {
        for (int j=1; j<array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (isGreaterThan(array[i-1], array[i])) {
                    String temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public static void sortReverse(String[] array) {
        for (int j=1; j<array.length; j++) {
            for (int i = 1; i < array.length; i++) {
                if (!isGreaterThan(array[i-1], array[i])) {
                    String temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }

    public static String getFirstValue(String[] array) {
        for (int j = 0; j<array.length; j++) {
            if (!array[j].equals("")) {
                String temp = array[j];
                array[j] = "";
                return temp;
            }
        }
        return "";
    }

    public static void printArray(String[] array) {
        for (String string : array) {
            System.out.println(string);
        }
    }

}
