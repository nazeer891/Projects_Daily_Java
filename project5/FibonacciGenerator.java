package package5;

import java.math.BigInteger;
import java.util.Scanner;

class FibonaciSeriesGenerator{

    public void generateIterative(int n){
        System.out.println("\n--- Iterative Approach (Using BigInteger)---");
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for(int i = 0; i < n; i++){
            System.out.print(a +" ");
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
    }
    public BigInteger recursiveFib(BigInteger n){
        if(n.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return recursiveFib(n.subtract(BigInteger.ONE)).add(recursiveFib(n.subtract(BigInteger.valueOf(2))));
    }
}
public class FibonacciGenerator {
    static {
        System.out.println("===== Project 5 - Java Programming =====\n");
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true){
            try{
                System.out.print("Enter the number of terms (n) (eg. 5, 6 ...): ");
                String usrInput = scanner.nextLine();
                if(usrInput.isEmpty()) throw new Exception();
                n = Integer.parseInt(usrInput);
                break;
            } catch (Exception e){
                System.out.println("Invalid Input, try again");
            }
        }

        FibonaciSeriesGenerator fibGen = new FibonaciSeriesGenerator();
        fibGen.generateIterative(n);

        // Recursive Approach
        System.out.println("\n--- Recursive Approach (Restricted till n = 40)---");
        for(int i=0;i<Math.min(n,40);i++){
            System.out.print(fibGen.recursiveFib(BigInteger.valueOf(i))  +" ");
        }
        if (n > 40) System.out.print("... (Recursive limit reached)");

        scanner.close();
    }
}