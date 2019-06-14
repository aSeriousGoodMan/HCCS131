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
 *  Outputs a formatted version of the file to table.out,
 *  and a graph of the histogram using the StdDraw library.
 *
 *  Usage: java Grader filename
 *  Example: java Grader fileLarge.txt
 *----------------------------------------------------------------*/
import java.awt.Color;

public class Grader {

    public static void main(String[] args) {

        // Check to make sure the user provided a file name argument.
        if (args.length != 1) {
            StdOut.println("Sorry, you must supply the name of a grade file as an argument.");
            System.exit(1);
        }

        // Open the input file.
        In fileReader = new In(args[0]);

        // Read two integers
        int numPeople = fileReader.readInt();
        int numAssignments = fileReader.readInt();

        // There is no point if there are no students or no assignments
        if (numAssignments <= 0 || numPeople <= 0)
            System.exit(0);

        // Declare variables tohold all the data.
        // List of student names
        String[] names = new String[numPeople];
        // List of assignment titles
        String[] assignments = new String[numAssignments];
        // Matrix of students and their grades on each assignment
        int [][]grades = new int[numPeople][numAssignments]; 
        // List of averages, one for each student
        double[] studentAvg = new double[numPeople];

        // Read all the remaining input data from the file, including the
        // assignment names and student grades, and calculate some averages.

        // TO DO .....................
        // CUT AND PASTE YOUR CODE FROM GetGrades.java HERE
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
	}
        // ................................................

        // This section 
        //    Sums the grades for each assignment
        //    and then calculates the class average for 
        //    the assignment and stores the average in a list.
        double[] assignmentAvg = new double[numAssignments]; // The class average for each assignment

        for (int i = 0; i < numAssignments; i++) {
            int sum = 0;
            for (int j = 0; j < numPeople; j++) {
                sum += grades[j][i];
            }
            assignmentAvg[i] = ((double) sum) / numPeople;
        } // run through each assignment

        // This section
        //     uses the average for each student to count
        //     the number of scores that fall in each "bucket", i.e. range
        //     0-9, 10-19, ... 100.  These count are stored in the 
        //     corresponding location in the distribution bucket array.
        //     So the count for 0-9 is stored in distribution[0],
        //     the count for 10-19 is stored in distribution[1], etc.
        //     The distribution array is used to create a histogram 
        //     and create a graph of the average grade for each student

        // There are a number of different "buckets" of
        // number ranges[0-10), [10-20), [20-30), .... [90-100), [100 and above]
        final int NUM_RANGES = 11;
        int[] distribution = new int[NUM_RANGES];
        // distribution holds a count of the scores in each range,
        // needed for both the text and graphical histogram

        for (int i = 0; i < numPeople; i++) {
            int dataGroup = 0;
            // Based on the value of 'score', i.e. studentAvg[i] increment the
            // appropriate element of the "buckets" distribution array.
            // NOTE: You did this in lab 5, so know that this can be done
            // in 1 or 2 lines of code if you are a little bit clever.
            // The direct approach might be 20 or more lines of code.
            // It is okay to handle the special case of 100 or above, put in last bucket
            dataGroup = (int) Math.floor(studentAvg[i] / 10.00);
            distribution[dataGroup]++; // says student's average is in that bucket
        }
        // The grade distribution
        // array that will be used to display the histogram graph.

        // This section
        //    Stores the column width for the
        //    student with the longest name.
        //    The width can be used to create formatted output.

        // find the width of the longest name
        int longestName = 0;
        for (int i = 0; i < numPeople; i++) {
            longestName = Math.max(longestName, names[i].length());
        }

        // The column format for student names is %-8, i.e. left justified in
        // a column of width 8. But we use the length of the longest name as
        // the width, instead of 8, if necessary.
        int nameColumnWidth = Math.max(8, longestName);
        String nameFormat = "%-" + nameColumnWidth + "s";

        // TO DO .....................
        // This display is not so nice.
        // Fix the formatting and change it so it displays to
        // table.out instead of to the Console.
        // ................................................

        // This section SHOULD
        //     display a formatted version of the input file.
        //     Every student's name must be left justified in a field width
        //     that is large enough to handle the longest name.
        //     The title of each assignment must be right justified
        //     in a field of ten.
        //     Each student's grade must be right justified within a field of ten.
        //     Each student's average must be printed to two decimal places,
        //     and right justified in a field of ten.
        //     The last line displayed is the class average on each assignment
        //     The assignment average must be calculated and then
        //     displayed to two decimal places and right justified in a field of ten.

	//Out Table = new Out(args[1]);
        // print the names of the assignments separated by one space
        StdOut.printf(nameFormat, "Student"); // first column is student name
        for(int i = 0; i < numAssignments; i ++) {
            StdOut.printf("%10s", assignments[i]);
        }
        StdOut.println(" " + "Average"); //last column is average for that student

        // loop through all the students
        for(int i = 0; i < numPeople; i++) {
            StdOut.printf(nameFormat, names[i]);

            // list all the grades for this particular student
            for(int j = 0; j < numAssignments; j++) {
                StdOut.printf("%10d", grades[i][j]);
            }
            // print the average for this student
            StdOut.printf("%10.2f", studentAvg[i]);

            // end the current line of output
            StdOut.println();
        } //for each student

        // print out the averages for each assignment
        StdOut.printf(nameFormat, "AVERAGE");
        for(int i = 0; i < numAssignments; i ++) {
            StdOut.printf("%10.2f", assignmentAvg[i]);
        }
        StdOut.println();

        // DONE with printing text to the Console

        // This section display a bar-graph histogram to the screen
        //    The number of ranges (i.e. buckets) is used to determine 
        //    the width of each bar on the graph.
        //    The bucket with the most scores is used to determine
        //    the vertical scale so the bar graph used the whole drawing area.

        int verticalScaling = 0;
        for (int i = 0; i < NUM_RANGES; i++) {
            verticalScaling = Math.max(verticalScaling, distribution[i]);
        }

        // For each of the buckets, draw a rectangle scaled to
        // number of students in that region
        // TO DO .....................
        // Vary the colors so that one bucket is easily
        // distinguishable from the neighboring range.
        // ................................................
        for (int i = 0; i < NUM_RANGES; i++) {
	    
	    int color = i*15; 
            StdDraw.setPenColor(color, 100, 200 - color); 

            // Scale the rectangle in the graph
            double[] leftBottom = {i / (NUM_RANGES*1.0), 0.0};
            double[] topRight = {(i + 1) / (1.0*NUM_RANGES), 
                                 (distribution[i] + 0.000000001) / verticalScaling}; 
            double[] center = {(leftBottom[0] + topRight[0]) / 2, 
                               (leftBottom[1] + topRight[1]) / 2};
            double[] dim = {(-1 * leftBottom[0] + topRight[0]) / 2, 
                            (-1 * leftBottom[1] + topRight[1]) / 2};

            // Actually do the drawing
            StdDraw.filledRectangle(center[0], center[1], dim[0], dim[1]);
        }

        // Draw horizontal lines, to visualize the number 
        // of students in a region
        // Make the lines the background color
        StdDraw.setPenColor(Color.WHITE);
        for (int i = 1; i < verticalScaling; i++) {
            double y = (double)i / verticalScaling;
            StdDraw.line(0, y, 1, y);
        }
        // DONE with graphical Display

    } // end of main

} // end of Grader class
