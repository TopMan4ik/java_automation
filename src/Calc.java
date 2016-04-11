import java.util.Scanner;


public class Calc {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please, enter first number: ");
        float number1 = in.nextFloat();
        System.out.print("Please, enter first number: ");
        float number2 = in.nextFloat();
        boolean isOperationCorrect = false;
        while (!isOperationCorrect) {
            System.out.print("Please, enter operation (addition - 1, subtraction - 2, multiplication - 3, division - 4): ");
            int operation = in.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Result of addition is: " + (number1 + number2));
                    isOperationCorrect = true;
                    break;
                case 2:
                    System.out.println("Result of subtraction is: " + (number1 - number2));
                    isOperationCorrect = true;
                    break;
                case 3:
                    System.out.println("Result of multiplication is: " + (number1 * number2));
                    isOperationCorrect = true;
                    break;
                case 4:
                    System.out.println("Result of division is: " + (number1 * number2));
                    isOperationCorrect = true;
                    break;
                default:
                    System.out.println("Operation is not recognized, try again");
            }
        }
    }



}
