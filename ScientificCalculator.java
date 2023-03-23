import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ScientificCalculator {

    // Method to calculate the factorial of a number using recursion
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    // Method to calculate the power of a number using a loop
    public static double power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // Method to calculate the natural logarithm of a number using a series approximation
    public static double ln(double x) {
        double result = 0;
        for (int n = 1; n <= 100; n++) {
            result += (1.0 / n) * power((x-1) / x, n);
        }
        return result;
    }

    // Method to generate a random number between 0 and 1
    public static double random() {
        Random rand = new Random();
        return rand.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean running = true;

        while (running) {  // Prompt the user to enter an operation to perform
            System.out.println("Enter an operation (+, -, *, /, ^, log, ln, !, sin, cos, tan, random, quit):");
            String operation = scanner.next();  // Read the user's input operation from the console

            switch (operation) {  // Evaluate the user's input operation using a switch statement
                case "+":
                    System.out.println("Enter a number:"); // Prompt the user to enter a number to add
                    double addend = scanner.nextDouble();
                    result += addend;
                    System.out.println("Result: " + result);
                    break;

                case "-": // Handle subtraction operation
                    System.out.println("Enter a number:");
                    double subtrahend = scanner.nextDouble();
                    result -= subtrahend;
                    System.out.println("Result: " + result);
                    break;

                case "*":
                    System.out.println("Enter a number:");
                    double factor = scanner.nextDouble();
                    result *= factor;
                    System.out.println("Result: " + result);
                    break;

                case "/":
                    System.out.println("Enter a number:");
                    double divisor = scanner.nextDouble();
                    if (divisor == 0) {
                        System.out.println("Error: Division by zero");
                    } else {
                        result /= divisor;
                        System.out.println("Result: " + result);
                    }
                    break;

                case "^":
                    System.out.println("Enter a base:");
                    double base = scanner.nextDouble();
                    System.out.println("Enter an exponent:");
                    int exponent = scanner.nextInt();
                    result = power(base, exponent);
                    System.out.println("Result: " + result);
                    break;

                case "log":
                    System.out.println("Enter a number:");
                    double logArg = scanner.nextDouble();
                    if (logArg <= 0) {
                        System.out.println("Error: Invalid argument");
                    } else {
                        result = Math.log10(logArg);
                        System.out.println("Result: " + result);
                    }
                    break;

                case "ln":
                    System.out.println("Enter a number:");
                    double lnArg = scanner.nextDouble();
                    if (lnArg <= 0) {
                        System.out.println("Error: Invalid argument");
                    } else {
                        result = ln(lnArg);
                        System.out.println("Result: " + result);
                    }
                    break;

                case "!":
                    System.out.println("Enter a number:");
                    int factorialArg = scanner.nextInt();
                    if (factorialArg < 0) {
                        System.out.println("Error: Invalid argument");
                    } else {
                        result = factorial(factorialArg);
                        System.out.println("Result: " + result);
                    }
                    break;

                case "sin":
                    System.out.println("Enter an angle in degrees:");
                    double sinArg = Math.toRadians(scanner.nextDouble());
                    result = Math.sin(sinArg);
                    System.out.println("Result: " + result);
                    break;

                case "cos":
                    System.out.println("Enter an angle in degrees:");
                    double cosArg = Math.toRadians(scanner.nextDouble());
                    result = Math.cos(cosArg);
                    System.out.println("Result: " + result);
                    break;

                case "tan":

                    System.out.println("Enter an angle in degrees:");
                    double tanArg = Math.toRadians(scanner.nextDouble());
                    result = Math.tan(tanArg);
                    System.out.println("Result: " + result);
                    break;

                case "random":
                    result = random();
                    System.out.println("Result: " + result);
                    break;

                case "quit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }
    }
}