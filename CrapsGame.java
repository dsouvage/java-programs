//Dylan Souvage 

import java.util.Scanner;
import java.io.*;
public class CrapsGame {

  public static void main(String[] args) {
    int myPoint;
    int d1,d2,d3;
    int rolls;
    double numberGames;
    int rollCount;
    int winCount;
    int lossCount;
    int rollCountMax = 0;
    int winsRowMax = 0;
    int lossRowMax = 0;
    int winsRow = 0;
    int lossRow = 0;
    double maxWins = 0;
    int maxLosses = 0;
    int rollTracker = 0;
    double totalRolls = 0;
    double avgRolls;
    double probWin;
    boolean win, rollagain, displayIndividual;
    Scanner kbd;

    kbd = new Scanner(System.in);
    
    //ask user for total number of games
    System.out.println("Enter # of games:");
    numberGames = kbd.nextDouble();
     
    //ask user for roll limit to count (ex if a game goes over 30 rolls
    //then it will count +1 each time that happens over a given loop
    System.out.println("Enter roll limit to count:");
    rollCount = kbd.nextInt();
   
    //ask user if they would like to track individual rolls and games
    //(not recommended for large amount of games)
    System.out.println("Display individual games (true/false):");
    displayIndividual = kbd.nextBoolean();
    
    //loops until the number of games desired is reached
    for (int x = 1; x <= numberGames; x++) {

    win=false;
    //call the rollDice function and assign it to d3
    d3 = rollDice(displayIndividual);    
    
    //Variable rolls will track amount of times that the game has been repeated
    //ex) 5 rolls to reach a loss or a win rather than a reroll
    rolls=1;    
    
    switch ( d3 ) {
      case 7: case 11:
        maxWins++;
        win=true;
        break;
      case 2: case 3: case 12:
        maxLosses++;
        win=false;
        break;
      default:
        myPoint = d3;
        rollagain=true;
        
        
        do {
          d3 = rollDice(displayIndividual);
          rolls++;                     
          
          if ( d3 == myPoint ){
            maxWins++;
              
            win=true;
            
            rollagain=false;
          }
          else if ( d3 == 7 ){       
            maxLosses++;
            
            win=false;

            rollagain=false;
          }
  
          
          
        } while (rollagain);
        
        //tracks max roll streak
        if (rolls > rollCountMax){
        rollCountMax = rolls;
        }
        
        //if the amount of rolls entered by the user has been reached, then it will
        //add one to the counter of the amount of times that number has been reached
        if (rolls > rollCount){
          rollTracker++;
        }
        
        

        
        
    } // end of switch
   
        //tracks wins in a row and losses in a row, also resets if 
        //win or loss is achieved
        if (win) {
        lossRow = 0;
        winsRow++;
        } 
        else {
        winsRow = 0;
        lossRow++;
        }
          
        //tracks maximum streak of win
        if (winsRowMax < winsRow){
        winsRowMax = winsRow;
        }
        
        //tracks maximum streak of losses
        if (lossRowMax < lossRow){
        lossRowMax = lossRow;
        }  
          
    
    
    
    //if user decides, then the result of each game will be displayed
    if(displayIndividual == true){
    if (win)
      System.out.printf("***WINNER***\n");
    else 
      System.out.printf("YOU LOSE\n");
   
    System.out.printf("It took %d rolls\n",rolls);
    }
    
    //adds the current roll count to the total amount of rolls
    totalRolls = rolls + totalRolls;
    }
    
    //calculates average number of rolls by dividing the total rolls by the number of games
    avgRolls = totalRolls / numberGames;  
    
    //converts maxWins back to an int for printing
    int j = (int) maxWins;
    
    //calculates probability of winning by dividing the number of wins by the total amt of games
    probWin = maxWins / numberGames;
    
    System.out.printf("\nAvg # of rolls: %.3f \n" , avgRolls); 
    System.out.println("Max # of rolls: " + rollCountMax);
    System.out.println("Over " + rollCount + " rolls: " + rollTracker); 
    System.out.println("# of wins " + j);
    System.out.println("# of losses "+ maxLosses); 
    System.out.printf("Prob. win: %.4f \n" , probWin);
    System.out.println("Max wins in a row was " + winsRowMax);
    System.out.println("Max losses in a row was " + lossRowMax);
  }
  
  //dice roller function
  public static int rollDice(boolean p) {
          int d1, d2, d3;  
          //if user wants to see individual rolls, then it will print
          //each roll, otherwise it will just return the sum of two rolls
          
          d1 = (int)(6*Math.random())+1;
          d2 = (int)(6*Math.random())+1;     
          d3 = d1+d2;

          if(p == true){
          System.out.printf("%d and %d\n",d1,d2);
          }
          
          return d3;
}
}
  
  





