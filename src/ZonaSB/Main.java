package ZonaSB;


import javax.management.OperationsException;
import java.util.Scanner;


class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        try {
            Double.parseDouble(array[0]);
            Double.parseDouble(array[2]);
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
            return;
        }
        try {
            System.out.println(calculate(array));
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculate(String[] array) {
        double n1 = Double.parseDouble(array[0]);
        double n2 = Double.parseDouble(array[2]);

        switch (array[1]) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0.0)
                    throw new IllegalArgumentException("Error! Division by zero");
                return Double.parseDouble(array[0]) / Double.parseDouble(array[2]);
            default:
                throw new ArithmeticException("Operation Error!");
        }


    }
}



