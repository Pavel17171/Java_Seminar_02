/* 
Ex_4*. Реализуйте простой калькулятор, с консольным интерфейсом. 
К калькулятору добавить логирование.
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Ex_04 {
    static String flag;

    public static void main(String[] args) throws SecurityException, IOException {

        Logger logger = Logger.getLogger("LogFile4");
        FileHandler fh;
        fh = new FileHandler("Ex_04_LogFile.log");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        String question = answer();
        while (question.equals("y")) {
            calculator();
            logger.info(flag);
            question = answer();
        }
        logger.info("end");
    }

    public static void calculator() {
        StringBuilder tempString = new StringBuilder();
        int num1 = getInt();
        String operator = getChar();
        int num2 = getInt();
        int result = operation(num1, num2, operator);
        System.out.println("Результат: " + result);
        tempString.append(num1 + " " + operator + " " + num2 + " = " + result);
        flag = toString(tempString);
    }

    public static int operation(int num1, int num2, String operator) {
        int result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("Некорректный ввод. Повторите");
                result = operation(num1, num2, getChar());
        }
        return result;
    }

    public static Integer getInt() {
        System.out.print("Введите число: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num;
    }

    public static String getChar() {
        System.out.print("Введите знак операции (+, -, *, /, %): ");
        Scanner scan = new Scanner(System.in);
        String sym = scan.next();
        return sym;
    }

    public static String toString(StringBuilder line) {
        String a = line.toString();
        return a;
    }

    public static String answer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Работаем? (Y/N) ");
        String answer = scan.next().toLowerCase();
        return answer;
    }
}