/*----------------------------------------------------------------
 *  Author:   L.King
 *  Email:    lking@holycross.edu
 *  Written:  7/27/2015
 *
 *  Creates a linked list of numbers that are entered
 *  interactively at the keyboard as the program
 *  executes.  Keeps entering numbers until -1 is entered.
 *
 *  Example: java Build
 *----------------------------------------------------------------*/

public class Build {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.print("Enter a number (or -1 to stop): ");
        int val = StdIn.readInt();

        while (val != -1) {
            list.insertRear(val);
            System.out.print("Enter another number (or -1 to stop): ");
            val = StdIn.readInt();
        } // while not done reading numbers

        list.print();
    } // main

} // end of Build Class
