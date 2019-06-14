/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  9/15/2016
 *  
 *  Simulates rolling two dice.
 *
 *  Example: java EvenOdd
 *----------------------------------------------------------------*/

public class EvenOdd {
    public static void main(String[] args) { 
        // Pick two random integers, each between 1 and 6.
        int a = (int)(1 + Math.random() * 6);
        int b = (int)(1 + Math.random() * 6);
	String pick = args[0];
	int sum = a + b;
	String result;
	if (sum == 1 || sum == 3 || sum == 5 || sum == 7 || sum == 9 || sum == 11) {
	    result = "Odd";
	}else if (sum == 8) {
	    result = "eight";
	}else {
	    result = "Even";
	}
	    
        // Print the results.
        if (a == b) {
            System.out.println("You rolled a pair of " + a + "s");
        } else {
            System.out.println("You rolled a " + a + " and a " + b);
        }
	System.out.println("The sum is " + sum);
	System.out.println("The result is " + result);
      if (result.equals(pick)) {
	    System.out.println("You Win!");
	    if (result.equals("eight")) {
		System.out.println("Your prize is $4");
	    }else {
		System.out.println("your prize is $1");
	    }
	}else {
	    System.out.println("Sorry, you lose");
      }
	
        
    } //end of main
} //end of EvenOdd
