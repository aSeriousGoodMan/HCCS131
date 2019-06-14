//***************************************************************************
// Histogram.java
//     Author:
//     Date:
//     Class:
//     Purpose: Generates a set of integers representing scores in the range
//              0 - 100 and diplays their distribution using a histogram.
//***************************************************************************

public class Histogram {
    public static void main(String[ ] args) {
        if (args.length != 1) {
            StdOut.println("Ooops, this program was expecting one command-line argument!");
            StdOut.println("Try running it like this:");
            StdOut.println("  java Histogram 50");
            System.exit(1);
        }

        int numGrades = Integer.parseInt(args[0]); //The number of grades to be entered
        int[ ] grades = new int[numGrades];   //Array containing the grades

        int numRanges = 11;             //Number of different ranges 0-9, 10-19,..100
        int[ ] buckets = new int[numRanges];  //a count of the scores in each range

        //Initialize buckets array to all 0
        for (int i = 0; i < numRanges; i++) {
            buckets[i] = 0;
        }

        //Generate an array of grades and print out each one
        for(int i = 0; i < numGrades; i++) {
            grades[i] = (int)(101*Math.random( ));
            System.out.print(grades[i] + " ");
        }
        System.out.println();

        //Traverse the grades array and increment the buckets array so that each
        //element in buckets indicates the number of grades in the corresponding range
        for(int i = 0; i < numGrades; i++) {
	    int score = grades[i];
	    buckets[score/10] += 1;
    }
	        
		
	    
	    
            // TODO: YOUR CODE GOES HERE
            // Based on the value of 'grade', increment the
            // appropriate element of the buckets array.
            // NOTE: This can be done in 1 line of code if you are a little bit clever.
            // Hint: Think integer division.
            // The direct approach might be 20 or more lines of code.
        

        //Draw a Histogram of the number of grades in each range
        System.out.println("Grade Distribution");
        System.out.println("------------------");
        for(int i = numRanges - 1; i >= 0; i--) {
	    int num = i;
	    if(num == 10) {
		 int star = buckets[i];
		 StdOut.print("  100 : ");
		 for(int j = star; j > 0; j--) {
		     StdOut.print("*");
		 }
		 StdOut.println();
	    }else if(num < 10 && num > 0) {
		int starr = buckets[i];
		StdOut.print(i + "9" + " - " + i + "0 : ");
		for(int k = starr; k > 0; k--) {
		    StdOut.print("*");
		}
		StdOut.println();
	    }else {
		StdOut.print("0 -  9  : ");
		for(int l = buckets[0]; l > 0; l--) {
		    StdOut.print("*");
		}
		StdOut.println();
	    }
	    
            // YOUR CODE GOES HERE
            // Display for i_th element of buckets array using
            // an appropriate label and row of '*'s.
            // NOTE: A little cleverness goes a long way. The same
            // few lines of code should suffice for printing nearly
            // all of the buckets. In fact, only one or two buckets
            // are special.
            // The following line should give insight into what
            // code you want here.  Once you fill in your histogram
            // check the values with
            //StdOut.print(i + " : " + buckets[i]);
            // Then replace the line with code that, instead of printing
            // the number in buckets[i], prints bucket[i] number of stars.
		 // StdOut.println();
        }
    }
}
