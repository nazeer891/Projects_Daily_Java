package project3;
import java.util.*;

class UserSelection{
    private char fromTemp, toTemp;
    private double fromTempData, tempConversion;
    private final Scanner scanner;
    UserSelection(Scanner scanner){
        this.scanner = scanner;
    }
    public void getFromTemp(){
        while(true){
            try {
                System.out.println("Enter convert temperature from: Celsius (C) / Fahrenheit (F) / Kelvin (K)");
                System.out.print("#: ");

                fromTemp = scanner.next().toLowerCase().charAt(0);
                if(!(fromTemp == 'c' || fromTemp == 'f' || fromTemp == 'k')){
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Try again");
            }
        }
    }
    public void getFromTempData(){
        getFromTemp();
        while (true){
            try{
                System.out.print("Enter valid from temperature: ");
                fromTempData = scanner.nextDouble();
                break;
            } catch (InputMismatchException e){
                System.out.println("Invalid input, try again.");
                scanner.next();
            }
        }
    }
    public void getToTemp(){
        while(true){
            try{
                System.out.print("Enter convert temperature to: ");
                if(fromTemp == 'c'){
                    System.out.print("Fahrenheit (F) / Kelvin (K)");
                } else if (fromTemp == 'f') {
                    System.out.print("Celsius (C) / Kelvin (K)");
                } else if (fromTemp == 'k') {
                    System.out.print("Celsius (C) / Fahrenheit (F)");
                }
                System.out.print("#: ");
                toTemp = scanner.next().toLowerCase().charAt(0);
                if(fromTemp == 'c' && (toTemp != 'f' && toTemp != 'k')){
                    System.out.println("Invalid choice, Try again");
                    continue;
                }else if(fromTemp == 'f' && (toTemp != 'c' && toTemp != 'k')){
                    System.out.println("Invalid choice, Try again");
                    continue;
                }else if(fromTemp == 'k' && (toTemp != 'f' && toTemp != 'k')){
                System.out.println("Invalid choice, Try again");
                continue;
                }
                break;
            } catch (Exception e){
                System.out.println("Invalid Input. Try again");
            }
        }
    }
    public void getTempConversion(){
        if(fromTemp == 'c'){
            if(toTemp == 'k') tempConversion = fromTempData + 273.17;
            else if (toTemp == 'f') tempConversion = (fromTempData * (9.0/5.0)) + 32;
        } else if (fromTemp == 'f') {
            if(toTemp == 'c') tempConversion = (fromTempData - 32) * (5.0/9.0);
            else if (toTemp == 'k') tempConversion = ((fromTempData - 32) * (5.0/9.0)) + 273.17;
        } else if (fromTemp == 'k') {
            if(toTemp == 'c') tempConversion = fromTempData - 273.17;
            else if (toTemp == 'f') tempConversion = ((fromTempData - 273.17) * (9.0/5.0)) + 32;
        }
    }
    public void displayResult(){
        System.out.printf("%.2f %c is equal to %.2f %c", fromTempData, Character.toUpperCase(fromTemp), tempConversion, Character.toUpperCase(toTemp));
    }
}

public class TemperatureConverter {
    static {
        System.out.println("===== Day 3 - Temperature Converter =====\n");
    }
    public static void main(String[] args){
        System.out.println("Conversion of temperatures between Celsius, Fahrenheit, and Kelvin based on user choice");

        // Scanner to get input from user
        Scanner scanner = new Scanner(System.in);
        UserSelection userSelection = new UserSelection(scanner);
        userSelection.getFromTempData();
        userSelection.getToTemp();
        userSelection.getTempConversion();
        userSelection.displayResult();

        scanner.close();
    }
}
