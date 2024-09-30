package org.example.fx.demo3;

import com.sun.source.tree.OpensTree;

import java.util.Scanner;

public class LoanApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Chris Loan Company");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter amount you want to borrow: ");
        double amount = scanner.nextInt();

        System.out.print("Enter number of years to pay back: ");
        int years = scanner.nextInt();

        double interest = 5.0;

        double monthlyPayment;
        double totalPayment;

        // Continue or terminate
        String option;

        System.out.println("Our interest rate is " + interest + "%" + " per annum");
        System.out.print("Do you agree to the terms? (input y for YES and n for NO): ");
        option = scanner.next();

        if (option.equalsIgnoreCase("n")) {
            System.out.println("Thank you for your patronage!");
            System.out.println("for more enquiries, contact 12345.");
            System.exit(10);
        }
        else if (option.equalsIgnoreCase("y")) {

            totalPayment = amount + (amount * interest * years) / 100;

            monthlyPayment = totalPayment / (12 * years);

            System.out.printf("The monthly payment is: %.2f", monthlyPayment);
            System.out.println();
            System.out.printf("The total payment is: %.2f", totalPayment);
            System.exit(11);
        }
        else {
            do {
                System.out.print("Incorrect input please enter y for YES or n for NO: ");
                option = scanner.next();

                if (option.equalsIgnoreCase("n")) {
                    System.out.println("Thank you for your patronage!");
                    System.out.println("You enquiry, contact 12345.");
                    System.exit(10);
                }

                if (option.equalsIgnoreCase("y")) {

                    totalPayment = amount +  (amount * interest * years) / 100;

                    monthlyPayment = totalPayment / (12 * years);

                    System.out.printf("The monthly payment is: %.2f", monthlyPayment);
                    System.out.println();
                    System.out.printf("The total payment is: %.2f", totalPayment);
                    System.exit(11);
                }

            } while (!option.equalsIgnoreCase("n") || !option.equalsIgnoreCase("y"));
        }

    }
}
