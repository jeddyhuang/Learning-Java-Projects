// ArrayLab1.java
// The "Sieve of Eratosthenes" Program
// This is the student, starting version of the TextLab06 assignment.


import java.text.DecimalFormat;
import java.util.Scanner;


public class Lab4
{
	public static void main(String args[])
	{
		// This main method needs additions for the 21 point version.
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("\nArray Lab 1\n");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the primes upper bound  ===>>  ");
		final int MAX = input.nextInt();
		boolean primes[];
		primes = new boolean[MAX];
		computePrimes(primes);
		displayPrimes(primes);
		*/
		System.out.println("\nArray Lab 1\n");
                Scanner input = new Scanner(System.in);
                System.out.print("Enter the primes upper bound  ===>>  ");
                final int MAX = input.nextInt();
                boolean primes[] = new boolean[MAX];
                computePrimes(primes);
                displayPrimes(primes);
	}

	public static void computePrimes(boolean primes[])
	{
		System.out.println("\nCOMPUTING PRIME NUMBERS");
                for(int i = 1; i < primes.length; i++)                          //go through the array one by one
                {
                    primes[i]= true;                                            //assign all the values to be prime except for one
                }
                for(int i = 1; i < primes.length; i++)                          //start the sequence from two
                {
                    if(primes[i] == true)                                       //check if the value is prime
                    {
                        for(int j = i+1; j < primes.length; j++)                //loop it so that it compares the integer to the rest of the numbers
                        {
                            if((j+1) % (i+1) == 0)                              //checks if it is divisible by the original number
                            {
                                primes[j] = false;                              //if divisible, assign the value as false
                            }
                        }
                    }
                }
        }

	public static void displayPrimes(boolean primes[])
	{
		System.out.println("\n\nPRIMES BETWEEN 1 AND "+ primes.length);
                for(int i = 0; i < primes.length; i++)                          //goes through the entire array
                {
                    if(primes[i] == true)                                       //checks if the array value is true
                    {
                        System.out.print(String.format("%04d", i+1) + " ");     //prints out the value for when the value is true
                    }
                }        
	}
}