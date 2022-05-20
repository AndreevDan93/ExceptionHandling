package ZonaSB;


import javax.management.OperationsException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws Exception {
        // FileReader fileReader = new FileReader("test.txt");


        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        try {
            System.out.println(calculate(array));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static double calculate(String[] array) throws Exception {
        double n1 = 0;
        double n2 = 0;

        try {
            n1 = Double.parseDouble(array[0]);
            n2 = Double.parseDouble(array[2]);

        } catch (Exception exception) {
            throw new Exception("Error! Not number");
        }

        switch (array[1]) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                if (n2 == 0.0)
                    throw new Exception("Error! Division by zero");
                return Double.parseDouble(array[0]) / Double.parseDouble(array[2]);
            default:
                throw new Exception("Operation Error!");
        }


    }
}




