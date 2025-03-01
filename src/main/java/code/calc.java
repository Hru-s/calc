package code;

import java.util.Scanner;
public class calc {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("\nScientific Calculator Menu:");
                System.out.println("1. Square Root (√x)");

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

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            scanner.close();
            System.out.println("Calculator closed.");
        }


    }


