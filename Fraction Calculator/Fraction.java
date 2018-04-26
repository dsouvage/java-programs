//Dylan Souvage 
import java.util.Scanner;

public class Fraction {
  //declares instance variables
  private long num;
  private long denom;
  
  //constructs fraction with 0 and 1
  Fraction(){
    num = 0;
    denom = 1;
  }
  
  //constructs fraction with numerator user value and 1 as denom
  Fraction(long n){
    num = n;
    denom = 1;
  }
  
  //constructs fractions with user inputted variables
  Fraction(long n,long d){
    num = n;
    denom = d;
  }
  
  //converts the fraction into double value
  double toDouble(Fraction f1){
    return (double) f1.num / (double) f1.denom;
  }    
  
  
  //method for converting to string
  String toString(Fraction f1){
    String fractionString = f1.num + "/" + f1.denom;
    return (fractionString);
  }
  
  //adds the sum of two fractions
  Fraction sum(Fraction f1,Fraction f2){
    Fraction f3;
    
    long d = f1.denom*f2.denom;
    long n = f1.num*f2.denom+f1.denom*f2.num;
    
    f3 = new Fraction(n,d);
    
    f3 = f3.SetSign(f3);
    
    return (f3);
  }
  
  //subtracts one fraction from another
  Fraction minus(Fraction f1,Fraction f2){
    Fraction f3;
    
    long d = f1.denom*f2.denom;
    long n = f1.num*f2.denom-f1.denom*f2.num;
    
    f3 = new Fraction(n,d);
    
    f3 = f3.SetSign(f3);
    
    return (f3);
  }
  
  //multiples two fractions
  Fraction product(Fraction f1,Fraction f2){
    Fraction f3;
    f3 = new Fraction(f1.num*f2.num,f1.denom*f2.denom);
    f3 = f3.SetSign(f3);
    return (f3);
  }
  
  //divides two fractions
  Fraction divide(Fraction f1,Fraction f2) throws ArithmeticException{
    //if the user has inputted any 0s for their denominator
    //then the program will throw an arithmetic exception 
    if (f2.denom == 0 || f1.denom == 0){
      throw new ArithmeticException("illegal denominator value");
    }
    else  {
      Fraction f3;
      f3 = new Fraction(f1.num*f2.denom,f1.denom*f2.num);
      f3 = f3.SetSign(f3);
      return (f3);
    }
  } 
  
  //method for setting the correct sign of a fraction
  private Fraction SetSign(Fraction fr){
    Fraction fs;
    
    fs = new Fraction(num, denom);
    //moves the negative sign to the numerator from the denominator
    //if both are negative then it makes the fraction positive
    //and if the numerator is 0, then it removes the negative 
    if (fr.num < 0 && fr.denom < 0){
      fs.num = (Math.abs(fr.num));
      fs.denom = (Math.abs(fr.denom));
    } else if (fr.num > 0 && fr.denom < 0 || (fr.num < 0 && fr.denom > 0)){
      fs.num = (0 - Math.abs(fr.num));
      fs.denom = (Math.abs(fr.denom));
    } else if (fr.num == 0){
      fs.num = 0;
      fs.denom = (Math.abs(fr.denom));
    }
    return (fs);
  }
  
  //method for printing a fraction by converting to string first
  void fractionPrint(Fraction fr){
    fr = fr.SetSign(fr);
    System.out.println(toString(fr));
  }
 
}
