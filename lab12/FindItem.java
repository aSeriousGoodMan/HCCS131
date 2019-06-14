/*----------------------------------------------------------------
 *  Author:   L.King
 *  Email:    lking@holycross.edu
 *  Written:  7/27/2015
 *
 *  Creates a linked list of numbers from the file values.dat
 *  Opens a file, e.g. find.dat, checks each number to determine
 *  if it was also in values.dat.  
 *  Counts the number of integers found.
 *  Uses the LinkedList and Node classes
 *
 *  Example: java FindItem find.dat
 *----------------------------------------------------------------*/

public class FindItem {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Ooops, you need to supply one command line argument, e.g. like this:");
            System.out.println("   java FindItem find.dat");
            System.exit(1);
        }

        String filename = args[0];

        LinkedList list = new LinkedList("values.dat");
        list.print();

        System.out.println ("\nSearching......");

        int number;        // a number to search for
        int numFound = 0;  // count of successful searches
        In inputStream = new In(filename);

        while (!inputStream.isEmpty()) {
            number = inputStream.readInt();

            System.out.print ("The target value " + number);

            if (list.contains(number)) {
                System.out.println (" was found in the list.");
                numFound++;
            } else {
                System.out.println (" was not found in the list.");
            }
        } // while there are more integers in the file

        System.out.printf("\nSummary: %d values from %s were found within values.dat\n", numFound, filename);

    } // end of main

} // end of FindItem Class
