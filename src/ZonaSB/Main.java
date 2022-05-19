package ZonaSB;


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] enterData = s.split(" ");
        if (!isNumber(enterData[0]) || !isNumber(enterData[2])) {
            System.out.println("Error! Not number");
        }
        if (!isOperation(enterData[1])) {
            System.out.println("Operation Error!");
        }
        if (enterData[2].equals("0") && enterData[1].equals("/")){
            System.out.println("Error! Division by zero");
        }







        try {

            if (!isNumber(enterData[0]) || !isNumber(enterData[2])) {
                throw new Exception("Error! Not number");
            }
            if (!isOperation(enterData[1])) {
                throw new Exception("Operation Error!");
            }
            if (enterData[2].equals("0") && enterData[1].equals("/")){
                throw new Exception("Error! Division by zero");
            }
            double result = getOperation(enterData[0],enterData[1],enterData[2]);
            System.out.println(result);

        } catch (Exception e) {
            e.getStackTrace();

        }


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
