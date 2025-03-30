import java.util.Scanner;
import java.io.*;

public class Calculator {
    public static void main(String args[]) throws FileNotFoundException{
        File file = new File("test.txt");
        Scanner sc = new Scanner(file);
        String[] s = sc.nextLine().split(" ");
        double a = 0, b = 0;
        boolean flag = true;
        try {
            a = Double.parseDouble(s[0]);
            b = Double.parseDouble(s[2]);
        } catch (NumberFormatException ex){
            System.out.println("Error! Not number");
            flag = false;
            return;
        }
        if ("+-*/".contains(s[1]) && flag){
            switch (s[1]){
                case "+": {System.out.println(a+b); break;}
                case "-": {System.out.println(a-b); break;}
                case "*": {System.out.println(a*b); break;}
                case "/": {
                    try {
                        if(b == 0.0)
                            System.out.println("Error! Division by zero");
                        else
                            System.out.println(a / b);
                    } catch (ArithmeticException ex) {
                        System.out.println("Error! Division by zero");
                    }
                    break;
                }
            }
        } else
            System.out.println("Operation Error!");
    }
}
