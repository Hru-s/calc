package code;

import java.util.Scanner;
public class calc {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("\nScientific Calculator Menu:");
                System.out.println("1. Square Root (√x)");
                System.out.println("2. Factorial (x!)");
                System.out.println("3. Natural Logarithm (ln(x))");
                System.out.println("4. Power (x^b)");
                System.out.println("5. Exit");
                System.out.print("Choose an operation (1-5): ");
                int choice = scanner.nextInt();

                if (choice == 5) break;

                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num = scanner.nextDouble();
                        System.out.println("√" + num + " = " + Math.sqrt(num));
                        break;
                    case 2:
                        System.out.print("Enter integer: ");
                        int n = scanner.nextInt();
                        System.out.println(n + "! = " + factorial(n));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        double lnNum = scanner.nextDouble();
                        System.out.println("ln(" + lnNum + ") = " + Math.log(lnNum));
                        break;
                    case 4:
                        System.out.print("Enter base (x): ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent (b): ");
                        double exp = scanner.nextDouble();
                        System.out.println(base + "^" + exp + " = " + Math.pow(base, exp));
                        break;


                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            scanner.close();
            System.out.println("Calculator closed.");

        }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


}


