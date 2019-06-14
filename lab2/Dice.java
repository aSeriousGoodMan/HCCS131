/*----------------------------------------------------------------
 *  Author:   K. Walsh
 *  Email:    kwalsh@holycross.edu
 *  Written:  7/4/2015
 *  Updated:  7/7/2015 - added better comments
 *  
 *  Prints a randomly-generated lucky number to the console.
 *
 *  Example: java Lucky Alice -5.0 10.0
 *
 *----------------------------------------------------------------*/

public class Dice {
    public static void main(String args[]) {

	// Put the three command-line arguments into variables.
	String name = args[0];
	int n = Integer.parseInt(args[1]);
        double r = Math.random();
        double bigger = r * n;
	long answer = Math.round(bigger + 0.5);
	System.out.println("Using a "+ n + "sided dice, " + name + " rolled a "+ answer);
    }
}

