import java.util.InputMismatchException; // C# thow new ArgunmentExeption
import java.util.Scanner;

public class PointProgramStarting {
    private static Scanner _scanner = new Scanner(System.in);

    public static int number1, number2;

    public static char operation;

    public static int result;

    public static void main(String[] args) {
        System.out.println("Add Value [2+2] or Two Rim value  I - X:[V+V]  and AddKeboard Enter ");

        String userAddWord = _scanner.nextLine();

        char[] under_char = new char[10];

        for (int i = 0; i < userAddWord.length(); i++) {

            under_char[i] = userAddWord.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }

        }
        String under_charString = String.valueOf(under_char);

        String[] blacks = under_charString.split("[+-/*]");

        String stableNull = blacks[0];

        String stableOne = blacks[1];

        String stringThree = stableOne.trim();

        number1 = _romanToNumber(stableNull);

        number2 = _romanToNumber(stringThree);

        if (number1 < 0 && number2 < 0) {

            result = 0;

        } else {
            result = Calculated(number1, number2, operation);

            System.out.println("result is Roman value");

            String resultRoman = _convertNumToRoman(result);

            System.out.println(stableNull + " " + operation + " " + stringThree + " = " + resultRoman);
        }
        number1 = Integer.parseInt(stableNull);

        number2 = Integer.parseInt(stringThree);

        result = Calculated(number1, number2, operation);

        System.out.println("Result is Arabik value");

        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
    }

    private static String _convertNumToRoman(int numArabian) {

        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        final String s = roman[numArabian];

        return s;

    }


    private static int _romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;

            } else if (roman.equals("II")) {
                return 2;

            } else if (roman.equals("III")) {
                return 3;

            } else if (roman.equals("IV")) {
                return 4;

            } else if (roman.equals("V")) {
                return 5;

            } else if (roman.equals("VI")) {
                return 6;

            } else if (roman.equals("VII")) {
                return 7;

            } else if (roman.equals("VIII")) {
                return 8;

            } else if (roman.equals("IX")) {
                return 9;

            } else if (roman.equals("X")) {
                return 10;

            }
        } catch (InputMismatchException e) {

            throw new InputMismatchException("not format");
        }
        return -1;
    }

    public static int Calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;

                break;

            case '-':
                result = num1 - num2;

                break;

            case '*':
                result = num1 * num2;

                break;

            case '/':
                try {

                    result = num1 / num2;

                } catch (ArithmeticException | InputMismatchException e) {

                    System.out.println("Exception : " + e);

                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }

                break;

            default:

                throw new IllegalArgumentException("No Znak operation");
        }
        return result;
    }
}