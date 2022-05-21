package ZonaSB;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws Exception {
        ArrayList arithmetic = readFile();
        for (Object s: arithmetic) {
            String str = s.toString();

            try {
                isNumber(str);
                isOperation(str);
                isZero(str);
                System.out.println(getOperation(str));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static ArrayList<String> readFile() throws Exception {
        ArrayList<String> arithmetic = new ArrayList<>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("Read.txt"));
            String s;

            while ((s = bufferedReader.readLine()) != null){
                arithmetic.add(s);
            }
            return arithmetic;

        }catch (Exception exception){
            throw new Exception("Error, can't read file");
        }
    }


    private static void isNumber(String s) throws Exception {
        try {
            String[] enterData = s.split(" ");
            Double.parseDouble(enterData[0]);
            Double.parseDouble(enterData[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Error! Not number");
        }
    }

    private static void isOperation(String s) throws Exception {
        String[] enterData = s.split(" ");
        if (enterData[1].equals("+") || enterData[1].equals("*") || enterData[1].equals("/") || enterData[1].equals("-"))
            ;
        else throw new Exception("Operation Error!");
    }

    private static void isZero(String s) throws Exception {
        String[] enterData = s.split(" ");
        if (enterData[2].equals("0") && enterData[1].equals("/")) throw new Exception("Error! Division by zero");
    }

    private static double getOperation(String s) throws Exception {
        String[] enterData = s.split(" ");
        switch (enterData[1]) {
            case "+":
                return Double.parseDouble(enterData[0]) + Double.parseDouble(enterData[2]);
            case "-":
                return Double.parseDouble(enterData[0]) - Double.parseDouble(enterData[2]);
            case "*":
                return Double.parseDouble(enterData[0]) * Double.parseDouble(enterData[2]);
            case "/":
                return Double.parseDouble(enterData[0]) / Double.parseDouble(enterData[2]);
            default:
                throw new Exception("exception");
        }

    }
}






