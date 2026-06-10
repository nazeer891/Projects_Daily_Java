package package5;

import java.math.BigInteger;
import java.util.Scanner;

class FibonacciSeriesGenerator{

    public void iterativeApproach(int n){
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for(int i=0; i<n ;i++){
            System.out.print(a+ " ");
            BigInteger next = a;
            a = b;
            b = b.add(next);
        }
    }

    public BigInteger recursiveApproach(BigInteger n){
        if(n.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
        return recursiveApproach(n.subtract(BigInteger.ONE)).add(recursiveApproach(n.subtract(BigInteger.valueOf(2))));
    }
}

public class FibonacciGenerator1 {
    static {
        System.out.println("=== Project 5 - Java Programming ===\n");
    }
    public static void main(String[] args){
        // initialize scanner
        Scanner scanner = new Scanner(System.in);
        int n;

        while (true){
            try{
                System.out.print("Enter the number of terms (n) (eg. 5, 6 ..): ");
                String usrInput = scanner.nextLine();
                if(usrInput.isEmpty()) throw new Exception();
                n = Integer.parseInt(usrInput);
                break;
            } catch (Exception e){
                System.out.println("Invalid input, Try again.");
            }
        }
        FibonacciSeriesGenerator fibGen = new FibonacciSeriesGenerator();
        System.out.println("\n----- Iterative Approach (Using BigInteger) ------\n");
        fibGen.iterativeApproach(n);

        System.out.println("\n----- Recursive Approach (Using BigInteger) ------\n");
        for(int i = 0;i<Math.min(n,40) ;i++){
            System.out.print(fibGen.recursiveApproach(BigInteger.valueOf(i)) +" ");
        }
        if (n > 40) System.out.print("... (Recursive limit reached)");
        scanner.close();
    }
}
