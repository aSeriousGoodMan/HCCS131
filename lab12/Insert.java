/*----------------------------------------------------------------
 *  Author:   L.King
 *  Email:    lking@holycross.edu
 *  Written:  7/27/2015
 *
 *  Creates an ordered linked list of numbers from the file "values.dat"
 *  Uses LinkedList and Node classes.
 *
 *  Example: java Insert
 *----------------------------------------------------------------*/
public class Insert {

    public static void main(String[] args) {

        LinkedList orderedList = new LinkedList();

        int number;        // a number to search for
        In inputStream = new In("values.dat");

        while (!inputStream.isEmpty()) {
            orderedList.print();
            number = inputStream.readInt();
            System.out.println("\nInserting: " + number + ".....");
            orderedList.insertOrdered(number);
        } //while numbers in the file
        orderedList.print();
    } //main

} //Ordered List Class
