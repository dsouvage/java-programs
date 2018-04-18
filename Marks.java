//Dylan Souvage

import java.util.Scanner;
import java.io.*;

public class Marks {

  public static void main(String[] args) throws FileNotFoundException {
     int id;
     int nbrLines, lineCount;
     double x,y,z,m;
     Scanner mydata;
     File inpdata;
     
     int f = 0;
     double m2 = 0;
     double x2 = 0;
     double y2 = 0;
     double z2 = 0;
     double l = 100;
     double h = 0;
     
     //retrieves the file that we will use for the marks processing
     inpdata=new File("studentdata.txt");
     mydata=new Scanner(inpdata);

     nbrLines=mydata.nextInt();
     
     lineCount=1;

     //title
     System.out.println("ID          Assign    Test      Exam      Mark");
     
     //loops until there are no more lines in the file
     while (lineCount<=nbrLines) {
        id=mydata.nextInt();
        x=mydata.nextDouble();
        y=mydata.nextDouble();
        z=mydata.nextDouble();
        
        //calculates the average mark of the students
        m = (x + y + z)/3;
        
        m2 = m2 + m;
        x2 = x2 + x;
        y2 = y2 + y;
        z2 = z2 + z;
        
        //if a student recieves a failing mark then a tally will be added to the total
        if (m < 50){
        f = f + 1;
        }
            
        //finds lowest of all students mark
        if (m < l){
        l = m;
        }
        
       //finds highest of all students mark
        if (m > h){
        h = m;
        }
               
        //prints all outputs to the second decimal place
        System.out.printf("%6d %9.2f %9.2f %9.2f %9.2f\n", id,x,y,z,m);

        //adds another loop
        lineCount=lineCount+1;

        
     }
     //figures out the average of the assignments, tests, exams and marks of all students
     //subtracts one from the total line count to remove the first line of the text file
     double m3 = m2 / (lineCount-1);
     double x3 = x2 / (lineCount-1);
     double y3 = y2 / (lineCount-1);
     double z3 = z2 / (lineCount-1);
     
     //prints the file to the nearest second decimal place
     System.out.printf ("Average %9.2f %9.2f %9.2f %9.2f\n",x3,y3,z3,m3);
     
     //prints number of failed students
     System.out.println ("# failed: "+ f);
     
     //lowest final mark
     System.out.printf ("The lowest final mark is %9.2f" , l);
     System.out.println();
     
     //highest final mark
     System.out.printf ("The highest final mark is %9.2f" , h);
     System.out.println();
  }

}

 
