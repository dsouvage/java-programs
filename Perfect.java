//6096101 Dylan Souvage Assignment 2 Question 2 

import java.util.Scanner;
public class Perfect {
    public static void main(String[] args) {
        int maxNbr;
        int sum1 = 0;
        Scanner kbd;
        kbd = new Scanner(System.in);
        
        /* Get a positive integer from the user */
        System.out.print("Enter a positive integer: ");
        maxNbr = kbd.nextInt();
        
        //loops until it recieves a positive number
        while (maxNbr <= 0) {
            System.out.print("Invalid. Enter a positive integer!: ");
            maxNbr = kbd.nextInt();
        }
        
        //loops until the inputed number is reached 
        for (int x = 1; x <= maxNbr; x++) {
            sum1 = 0;
            //checks if its a perfect number
            for (int y = 1; y < x; y++) {
                if ((x % y) == 0) {
                    sum1 = sum1 + y;
                    
                }                            
            }
            //if number is perfect print
            if (sum1 == x) {
                    System.out.println(sum1);
                    System.out.println("Given number is Perfect");
            }
        }
    }
}



