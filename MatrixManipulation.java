//Dylan Souvage

import java.util.Scanner;

public class MatrixManipulation {
  
  public static void main(String args[]) {
   
    Scanner kbd;
    //randarray
    int numR,numC,min,max;
    //identity
    int size;
    //reverse identity
    int size2;
    //transpose matrix
    int m, n;
    
    kbd = new Scanner (System.in);
    
    //random matrix
    System.out.println("Minimum int for random:");
    min = kbd.nextInt();
    
    System.out.println("Maximum int for random:");
    max = kbd.nextInt();
    
    System.out.println("Row Length for random matrix:");
    numR = kbd.nextInt();
  
    System.out.println("Column length for random matrix:");
    numC = kbd.nextInt();
    

    int[][] randomArray = randArray(numR, numC, min, max);
    
    
    
    //identity matrix
    System.out.println("Size of identity matrix:");
    size = kbd.nextInt();
    int [][] identityMatrix = identityMat(size);
    
 
    
    //reverse identity matrix
    System.out.println("Size of reverse identity matrix:");
    size2 = kbd.nextInt();
    int [][]reverseMatrix = reverseMat(size2);
    
    
    
    //transpose matrix
    System.out.println("Row length for transpose matrix:");
    m = kbd.nextInt();
    System.out.println("Column length for transpose matrix:");
    n = kbd.nextInt();
    int [][]transposeMatrix = transposeMat(m,n);
    
    //calls Subroutine MatrixDisplay 
    //which prints the other subroutines results
    //using the static routines returned arrays
    
    matrixDisplay(randomArray, identityMatrix, reverseMatrix, transposeMatrix);

}

  
//random matrix routine
public static int[][] randArray(int numR,int numC,int min,int max) {
    int rNbr;
    Scanner kbd;
    
    kbd = new Scanner (System.in);
    int[][] randomMatrix;

    randomMatrix=new int[numC][];
    
    //creates a matrix of numR/numC size 
    //containing random ints between min and max
    for (int i=0;i<numC; i++) {  
      randomMatrix[i]=new int[numR];
      for (int j=0;j<numR; j++)   {
        rNbr = min + (int)(Math.random()*((max - min)+1));   
        randomMatrix[i][j]=rNbr;
      }
    }  
    return randomMatrix;
  }

//identity matrix routine
public static int[][] identityMat(int size) {
    Scanner kbd;
    int[][] identityMatrix;
    
    //because an identity matrix is  
    //square we can use size twice
    identityMatrix=new int[size][size];
    
    //equates a value of 1 in a diagonal
    //(0,0)->(1,1)->(2,2) etc.
    for(int i = 0; i < size; i++) {
      identityMatrix[i][i] = 1;
    }
    
    
    return identityMatrix;
}

//reverse matrix routine
public static int[][] reverseMat(int size){
    int lastN;
    Scanner kbd;
    int[][] reverseMatrix;
    
    kbd = new Scanner (System.in);
   
    reverseMatrix=new int[size][size];
    
    //we subtract one from the length 
    //because arrays operate starting
    //from 0 and not 1, thus length-1
    lastN = reverseMatrix.length - 1;
    
    for(int i = 0; i < size; i++) {

      //calculates where to put the next value of 1
      //by removing one from the total length of the array
      //and then after each loop it subtracts one
      //from the previous loop
      
      reverseMatrix[i][lastN] = 1;
      lastN = lastN-1;
      
    }
    return reverseMatrix;
}

//transpose routine
public static int[][] transposeMat(int m, int n){
  int counter;
  int transposer[][];
  int data[][];
  Scanner kbd;
  int[][] transposeMatrix;
  
  kbd = new Scanner (System.in);
  

  
  transposeMatrix=new int[n][];
  counter = 1;
  
  //creates a regular matrix of m/n size
  for (int i=0;i<n; i++) {  
    transposeMatrix[i]=new int[m];
    for (int j=0;j<m; j++)   { 
      transposeMatrix[i][j]=counter;
      counter=counter+1;
      }
  } 
  
  //transposes the created matrix
  transposer = new int[m][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      transposer[j][i] = transposeMatrix[i][j];
    }
  }
  
  
  return transposer;
}

//print routine (unsure if should ask for variables 
//in sequence here or in main program

public static void matrixDisplay(int[][] randomArray, int[][] identityMatrix, int[][] reverseMatrix, int[][] transposeMatrix){
  
  //each section calls the respective routine
  //then prints the array line by line
  //via a for loop
  
  
  System.out.println("----------");
  System.out.println("Part 1, Random Array");
  System.out.println("----------");  
   
  //randArray
  for (int i=0; i<randomArray.length;i++) {
    for (int j=0;j<randomArray[0].length;j++) {
      System.out.printf("%4d",randomArray[i][j]);
    }
    System.out.println();
  }
      
  
  
  System.out.println("-------------");
  System.out.println("Part 2, Identity Matrix");
  System.out.println("-------------");  
    
  //identityMat
  for (int i=0; i<identityMatrix.length;i++){
    for (int j=0;j<identityMatrix.length;j++){
      System.out.printf("%4d",identityMatrix[i][j]);
      
    }
    System.out.println(); 
  }
  
  System.out.println("-------------");
  System.out.println("Part 3, Reverse Identity Matrix");
  System.out.println("-------------"); 
  
  //reverseMat
  for (int i=0; i<reverseMatrix.length;i++){
    for (int j=0;j<reverseMatrix.length;j++){
      System.out.printf("%4d",reverseMatrix[i][j]);
      
    }
    System.out.println(); 
  }
  
  System.out.println("-------------");
  System.out.println("Part 4, Transpose Matrix");
  System.out.println("-------------");  
  
  //transposeMat
  for (int i=0;i<transposeMatrix.length;i++){
    for (int j=0;j<transposeMatrix[0].length;j++){ 
      System.out.printf("%4d",transposeMatrix[i][j]);
      
    }
    System.out.println(); 
  }  

  
}
}



