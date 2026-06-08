package project1;

import java.util.Scanner;

public class SimpleCalculator {
    static {
        System.out.println("=== Day 1: Simple Calculator ===\n");
    }
    public static void main(String[] args){
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Get first number from user
        System.out.print("Enter the first number: ");
        while(!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid number");
            scanner.next();
        }
        double num1 = scanner.nextDouble();

        // Get second number
        System.out.print("\nEnter the second number: ");
        while(!scanner.hasNextDouble()){
            System.out.println("Invalid input. Please enter a valid number");
            scanner.next();
        }
        double num2 = scanner.nextDouble();

        // Get the operator
        System.out.print("\nEnter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // store the result
        double result = 0;
        boolean validCalculation = true;

        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
            case '/':
                try{
                    if (num2 == 0) {
                        throw new ArithmeticException("Divide by zero not allowed");
                    }
                    result = num1 / num2;
                } catch (ArithmeticException e){
                    System.out.println("Error caught: "+e.getMessage());
                    validCalculation = false;
                }
                break;
            default:
                System.out.println("Invalid operator, process aborted.");
                validCalculation = false;
                break;
        }

        // Display the result if the operation is successfully completed
        if(validCalculation){
            System.out.println("The result of "+num1+" "+operator+" "+num2+" is "+result);
        }

        scanner.close();
    }
}
