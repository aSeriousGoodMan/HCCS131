/*----------------------------------------------------------------
 *  Author:   
 *  Email:    
 *  Written:  
 *
 *  Reads a file of the form:
 *  #students  #assignments
 *  List of assignment titles (must be #assignments of them)
 *  #students lines, with each line having a first and
 *                   last name followed by #assignment scores
 *  Outputs the data to the Console,
 *
 *  Usage: java GetGrades filename
 *  Example: java GetGrades fileLarge.txt
 *----------------------------------------------------------------*/
import java.awt.Color;

public class GetGrades {

    public static void main(String[] args) {

        // Check to make sure the user provided a file name argument.
        if (args.length != 1) {
            StdOut.println("Sorry, you must supply the name of a grade file as an argument.");
            System.exit(1);
        }
        String filename = args[0];

        // Open the input file.
        In fileReader = new In(filename);

        // Read two integers
        int numPeople = fileReader.readInt();
        int numAssignments = fileReader.readInt();
        StdOut.printf("There are %d people and %d assignments in the file %s\n",
                numPeople, numAssignments, filename);

        // There is no point if there are no students or no assignments
        if (numAssignments <= 0 || numPeople <= 0)
            System.exit(0);

        // Declare variables to hold all the data.
        // List of student names
        String[] names = new String[numPeople];
        // List of assignment titles
        String[] assignments = new String[numAssignments];
        // Matrix of students and their grades on each assignment
        int [][]grades = new int[numPeople][numAssignments]; 
        // List of averages, one for each student
        double[] studentAvg = new double[numPeople];

	for(int i = 0; i < numAssignments; i++) {
	    assignments[i] = fileReader.readString();
	}
	    
	for (int i = 0; i < numPeople; i++) {
	    names[i] = fileReader.readString() + " " + fileReader.readString();
	    int sum = 0;
	    for(int j = 0; j < numAssignments; j++) {
		grades[i][j] = fileReader.readInt();
		sum+= grades[i][j];
		studentAvg[i] = sum/numAssignments;
	    }
		
		//grades[i][j] = fileReader.readInt();
	    
	}

        // Read all the remaining input data from the file, including the
        // assignment names and student grades, and calculate some averages.
        //
        // TODO: Add your code here to read
        // from the file and calculate averages.
        // ...
        // ...

        // print the names of the assignments
        for(int i = 0; i < numAssignments; i ++) {
            StdOut.print(assignments[i] + " ");
        }
        StdOut.println();

        // loop through all the students
        for(int i = 0; i < numPeople; i++) {
            StdOut.print(names[i] + " ");

            // list all the grades for this particular student
            for(int j = 0; j < numAssignments; j++) {
                StdOut.print(grades[i][j]+ " ");
            }
            // print the average for this student
            StdOut.print(studentAvg[i]);

            // end the current line of output
            StdOut.println();
        }
        StdOut.println ();

    } // end of main

} // end of GetGrades class
