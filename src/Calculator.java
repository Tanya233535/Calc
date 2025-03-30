import java.util.Scanner;
import java.io.*;

public class Calculator {
    public static void main(String args[]) {
        File inputFile = new File("input.txt");
        File outputFile  = new File("output.txt");

        try (Scanner sc = new Scanner(inputFile);
             PrintWriter pw = new PrintWriter(outputFile)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] s = line.split(" ");
                double a = 0, b = 0;
                boolean flag = true;
                String result = "";

                try {
                    a = Double.parseDouble(s[0]);
                    b = Double.parseDouble(s[2]);
                } catch (NumberFormatException ex) {
                    result = "Error! Not number";
                    flag = false;
                }

                if ("+-*/".contains(s[1]) && flag) {
                    switch (s[1]) {
                        case "+": {
                            result = String.valueOf(a + b);
                            break;
                        }
                        case "-": {
                            result = String.valueOf(a - b);
                            break;
                        }
                        case "*": {
                            result = String.valueOf(a * b);
                            break;
                        }
                        case "/":
                            if (b == 0.0) {
                                result = "Error! Division by zero";
                            } else {
                                result = String.valueOf(a / b);
                            }
                            break;
                    }
                } else if (flag) {
                    result = "Operation Error!";
                }
                String outputLine = line + " = " + result;
                pw.println(outputLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }
}
