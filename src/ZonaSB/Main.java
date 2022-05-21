package ZonaSB;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arithmetic = readFile();

        for (int i = 0; i < arithmetic.size(); i++) {
            String str = arithmetic.get(i);
            String result = "";
            try {
                isNumber(str);
                isOperation(str);
                isZero(str);
                Double calculate = getOperation(str);
                result = str + " = " + calculate.toString();

            } catch (Exception e) {
                result = str + " = " + e.getMessage();
            } finally {
                arithmetic.set(i, result);
            }
        }
        writeFile(arithmetic);
    }

    private static ArrayList<String> readFile() throws Exception {
        ArrayList<String> arithmetic = new ArrayList<>();
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\JavaProjects\\problems\\src\\ZonaSB\\Read.txt"));
            String s;

            while ((s = bufferedReader.readLine()) != null) {
                arithmetic.add(s);
            }
            bufferedReader.close();
            return arithmetic;

        } catch (Exception exception) {
            throw new Exception("Error, can't read file");
        }
    }

    private static void writeFile(ArrayList<String> arithmetic) throws Exception {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\JavaProjects\\problems\\src\\ZonaSB\\Write.txt"));
        for (String s : arithmetic) bufferedWriter.write(s + "\n");
        bufferedWriter.close();


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






