//Dylan Souvage

import java.util.Scanner;

public class RandomArray {
  public static void main(String[] args){
    
    int[] anArray ;
    int nRand;
    int myInt;      
    int rNbr;
    int perLine;
    int n;
    int first;
    int second;
    int counter;
    int firstLoop;
    int mostFrequent;
    int nbrTrackMost;
    int leastFrequent;
    int nbrTrackLeast;
    Scanner kbd;

    kbd=new Scanner(System.in);

    System.out.println("Random integers between 1 and n:");
    n = kbd.nextInt();
    
    //Creates an array of n size
    anArray = new int[n];
    
    System.out.println("How many Trials ");    
    nRand = kbd.nextInt();
    
    
    System.out.println("How many frequencies per line?");
    perLine = kbd.nextInt();

    for (int i=1; i<=nRand; i++) {
    //generates the random numbers between 0 and a user specified amount
    rNbr = (int)(Math.random()*n);    
    
    //counts the amount of times a specific random number is generated
    anArray[rNbr] = anArray[rNbr] + 1 ;
    }
    
    counter = 0;
    first = 1;
    second = perLine;
    
    System.out.println("Random integer Frequency Table (" + nRand + " Trials)");
    
    //initializes all of the trackers
    mostFrequent = anArray[0];
    leastFrequent = anArray[0];
    
    nbrTrackMost = anArray[0];
    nbrTrackLeast = anArray[0];
    
    
    do {
      //prints the range of the array's position
      //and also formats the printing
      System.out.printf("%2d", first);
      System.out.print("-");
      System.out.printf("%2d",second);
      
      //calculates which frequencies are being displayed
      first = first + perLine;
      second = second + perLine;
      
      //if either first or second exceeds the size of the array, then
      //equal the numbers to the size of the array
      if (first > n){
        first = n;
      }
      
      if (second > n){
        second = n;
      }
      
      //prints the amount of frequencies the user has inputted
      //on a single line
      for (int loop2=0; loop2 < perLine; loop2++){
        if (counter < n){
         
          //checks if a new highest frequency exists
          //if it does, then it updates the highest frequency
          if (anArray[counter] > mostFrequent){
          mostFrequent = anArray[counter];
          //counter + 1 because arrays start at 0
          nbrTrackMost = counter+1;
          }
          
          //checks if a new lowest frequency exists
          //if it does, then it updates the lowest frequency          
          if (anArray[counter] < leastFrequent){
          leastFrequent = anArray[counter];
          //counter + 1 because arrays start at 0
          nbrTrackLeast = counter+1;
          }
          
          System.out.printf("%4d" , anArray[counter]);
          counter++;      
        }
      }
     System.out.println(); 
     
     //loops until n is reached or the array is exhausted
    } while (counter < n);
    
    System.out.println("The most frequent number " + nbrTrackMost + " occurred " + mostFrequent + " times.");
    System.out.println("The least frequent number " + nbrTrackLeast + " occurred " + leastFrequent + " times.");
    
  }
}
