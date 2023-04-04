import java.util.*;
import java.math.BigInteger;
import java.util.Random;
public class Test
{
        public static void main(String[] args) 
        {
            // Create a random number generator
            Random random = new Random();

            // Generate a random BigInteger with 100 digits
            BigInteger randomBigInt = new BigInteger(100, random);
            System.out.println("Randomly generated BigInteger: " + randomBigInt);
            Next_Smallest_Palindrome ob = new Next_Smallest_Palindrome();
            System.out.println("Next Smallest Palindrome = "+ob.solve(""+randomBigInt));
        }
}