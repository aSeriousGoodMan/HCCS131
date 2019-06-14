//**************************************************************************
// MultTable.java
//     Author:
//     Date:
//     Class:
//     Purpose: Create a M x N exponentiation table and compute statistics
//              Perform exponentiation by retrieving from the table
//**************************************************************************

public class MultTable {
    public static void main(String[ ] args) {
        int numRows = 8;                        //Maximum rows.
        int numCols = 6;                        //Maximum columns.
        int[ ][ ] matrix = new int[numRows][numCols]; //Array with space for table.

	for(int i = 0; i < numRows; i++) {
	    for(int j = 0; j< numCols; j++) {
		matrix[i][j] = (int)Math.pow(i+1,j+1);
	    }
	}
		

        //Compute values for table and store them in the matrix
        // FIXME: ADD YOUR CODE HERE TO FILL IN THE TABLE


        //Print out the table
        System.out.println("Here is an 8 x 6 Expponentiation Table");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println( );
        }
        System.out.println( );

        System.out.println("First row: " );
	//Print out the first row
	for(int i = 0; i < numCols; i++) {
	    StdOut.print(matrix[0][i] + " ");
	}
        // FIXME: ADD YOUR CODE HERE TO PRINT OUT THE FIRST ROW
        System.out.println( );
        System.out.println( );

        System.out.println("Last column: ");
	for(int i = 0; i < numRows; i++) {
	    StdOut.println(matrix[i][5]);
	}

	//Print out the last column
        // FIXME: ADD YOUR CODE HERE TO PRINT OUT THE LAST COLUMN
        System.out.println();

        //Find the average of items in the table
        int sum = 0;
        double average = 0;
	int count = 0;
	for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                sum += matrix[i][j];
		count++;
	    }
	}
	average = sum/count;
	
        // FIXME: ADD YOUR CODE HERE TO COMPUTE THE AVERAGE OF ALL THE VALUES 
        // IN THE TABLE

        System.out.println("The average value is: " + average);
        System.out.println( );

        System.out.print("Would you like to find an exponent? [y/n] ");
        String resp = StdIn.readString();
        while (resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("y")) {
            System.out.println("Type two integers. ");
            System.out.print("The first number is the base and must be between 1 and 8: ");
            int a = StdIn.readInt();
            System.out.print("The second number is the exponent and must be between 1 and 6: ");
            int b = StdIn.readInt();
            if (a < 1 || a > numRows) {
                System.out.println("The first number must be between 1 and " + numRows);
                continue;
            }
            if (b < 1 || b > numCols) {
                System.out.println("The second number must be between 1 and " + numCols);
                continue;
            }

            // Print the exponent of a ^ b, but don't use Math.pow().
            // Instead, obtain the result by accessing the appropriate array element
            // FIXME: ADD YOUR CODE HERE TO PRINT OUT THE ARRAY ELEMENT WITH THE SOLUTION
            System.out.println("Raising of " + a + " by the power " + b  + " is: " + matrix[a-1][b-1]);

            // See if they want to find more exponents...
            System.out.print("Would you like to find more exponent values? [y/n] ");
            resp = StdIn.readString();
        }

        System.out.println("Goodbye!");

    }
}
