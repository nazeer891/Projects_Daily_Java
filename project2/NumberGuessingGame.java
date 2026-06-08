package project2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class GuessNumber{
    private final int randInt;
    private final Scanner scanner;
    private static final int MAX_GUESS = 10;
    private final int min;
    private final int max;
    public GuessNumber(int randInt,int min, int max,Scanner scanner){
        this.randInt = randInt;
        this.min = min;
        this.max = max;
        this.scanner = scanner;
    }

    public void userGuess(){
        int guesses = 0;
        System.out.println("You need to guess a number between "+min+":"+max);
        System.out.println("You have a total of "+MAX_GUESS+" attempts");
        while(guesses < MAX_GUESS){
            guesses++;

            System.out.print("Guess #"+(guesses)+": ");
            int usrGuess;
            try {
                usrGuess = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid Input, re-enter new value");
                scanner.next();
                guesses--;
                continue;
            }

            if(usrGuess < min || usrGuess > max){
                System.out.println("Out-of bound error, re-enter new value");
                scanner.next();
                guesses--;
                continue;
            }
            if(usrGuess == randInt){
                System.out.println("Congrats, you won in "+guesses+ " guesses");
                return;
            } else if(usrGuess > randInt){
                System.out.println("Try to guess a small number");
            } else {
                System.out.println("Try to guess a bigger number");
            }

            if(MAX_GUESS == guesses){
                System.out.println("You have exhausted all your guess. The number to guess was "+randInt);
            } else {
                System.out.println("You have " + (MAX_GUESS - guesses) + " attempts");
            }
        }
    }
}

public class NumberGuessingGame {
    static {
        System.out.println("====== Day2 - Number Guessing Game ======\n");
    }
    public static void main(String[] args){
        int min = 1;
        int max = 100;
        // create a random object
        Random random = new Random();

        try (Scanner scanner = new Scanner(System.in)){
            while(true) {
                // Assign a random value from 1 - 100
                int randInt = random.nextInt((max - min) + 1) + min;

                // create constructor and pass the random number
                GuessNumber game = new GuessNumber(randInt,min,max,scanner);
                game.userGuess();
                // Pass the value to guessNumber class
                System.out.print("Do you want to play again (Yes/ No) ? ");
                String usrInput = scanner.next();
                if(usrInput.toLowerCase().startsWith("n")){
                    System.out.println("Thanks for playing, Have a good day.");
                    break;
                }
            }
        }
    }
}
