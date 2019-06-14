//**************************************************************************
// ArrayStats.java
//     Author:
//     Date:
//     Class:
//     Purpose: Compute statistics for a list of grades.
//**************************************************************************

public class ArrayStats {

    static final int MAX_NUM_GRADES = 100;

    public static void main(String[ ] args) {
        if (args.length != 1) {
            StdOut.println("Ooops, this program was expecting one command-line argument!");
            StdOut.println("Try running it like this:");
            StdOut.println("  java ArrayStats 10");
            System.exit(1);
        }

        int[ ] grades = new int[MAX_NUM_GRADES];   //Array with space for up to 100 grades.

        int numGrades = Integer.parseInt(args[0]); //The number of grades to be entered

        for (int i = 0; i < numGrades; i++) {      //Generate some grades for practice
            grades[i] = (int)(100*Math.random( ));
        }

        for (int i = 0; i < numGrades; i++) {     //Print out the grades
            System.out.print(grades[i] + " ");
        }
        System.out.println( );

        System.out.print("First grade is " + grades[0]);     //Print out the first grade
        //TODO: Add code here
        System.out.println( );                   //Start new line

        System.out.print("Last grade is " + grades[numGrades - 1]);       //Print out the last grade
        //TODO: Add code here
        System.out.println( );                   //Start new line

        //Find the average of items in the array
        int sum = 0;
        for (int i = 0; i < numGrades; i++) {
            sum += grades[i];
        }
        double average = (double)sum/(double)numGrades;
        System.out.println("The average grade is: " + average);

        //Find the maximum value in the array
        int max = grades[0];  //maximum element seen so far
        for (int i = 1; i < numGrades; i++) {
            if (grades[i] > max) {
                max = grades[i];
            } //current max is the largest seen so far
        }
        System.out.println("The maximum grade is: " + max);

	int min = grades[0];  //maximum element seen so far
        for (int i = 1; i < numGrades; i++) {
            if (grades[i] < min) {
                min = grades[i];
            } //current max is the largest seen so far
        }
        System.out.println("The minumum grade is: " + min);
    }
}
