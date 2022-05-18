package ZonaSB;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] enterData = s.split(" ");
        if (!isNumber(enterData[0]) || !isNumber(enterData[2])) System.out.println("Error! Not number");
        else if (!isOperation(enterData[1])) System.out.println("Operation Error!");
        else if (Integer.parseInt(enterData[2]) == 0 && enterData[1].equals("/"))
            System.out.println("Error! Division by zero");
        else System.out.println(getOperation(enterData[0],enterData[1],enterData[2]));
    }

    private static boolean isNumber(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperation(String s) {
        if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) return true;
        else return false;

    }

    private static double getOperation(String a, String o, String b) {
        if (o.equals("+")) return Double.parseDouble(a) + Double.parseDouble(b);
        else if (o.equals("*")) return Double.parseDouble(a) * Double.parseDouble(b);
        else if (o.equals("/"))return Double.parseDouble(a) / Double.parseDouble(b);
        else   return Double.parseDouble(a) - Double.parseDouble(b);

    }
}