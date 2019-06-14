/*----------------------------------------------------------------
 *  Author:   Z.Lucas
 *  Email:    lking@holycross.edu
 *  Written:  7/14/2015
 *
 *  A client program that 
 *  tests the simple Rectangle methods described on page 406.
 *
 *  The Rectangle class definition is in the file, Rectangle.java
 *  Rectangle class instance variables:
 *    Coordinates (x,y) indicate the center of the circle,
 *    width, height, and
 *    isFilled indicates whether or not std draw fills in the shape
 *                                   or just outlines it.
 *  Methods include area(), perimeter(), contains(), intersect(),
 *                  and show().
 *
 *  Example: java TwoBoxes
 *----------------------------------------------------------------*/

import java.awt.Color;

public class TwoBoxes {

    public static void main(String[] args) {
        System.out.println ("=======================================");
        System.out.println ("    Test Two Rectangles                ");
        System.out.println ("=======================================");

        Rectangle one = new Rectangle (.25, .3, .1, .2, true); // x, y, width, height, filled?
        Rectangle two = new Rectangle(.35, .3, .5, .4, false); 

        System.out.printf ("Red perimeter should be 0.60, Rectangle class says it is %.2f \n", one.perimeter()); 
        System.out.printf ("Blue area should be 0.20, Rectangle class says it is %.2f \n", two.area()); 

        if (one.contains(two)) {
            System.err.println ("Error: the red rectangle does not contain the blue rectangle, test failed.");
        } else {
            System.out.println ("YES! the red rectangle does not contain the blue rectangle, test passed. ");
        }

        if (two.contains(one)) {
            System.out.println ("YES! the blue rectangle contains the red rectangle, test passed. ");
        } else {
            System.err.println ("Error: the blue rectangle contains the red rectangle, test failed.");
        }

        if (one.intersects(two)) {
            System.err.println ("Error: the rectangles do not intersect, test failed.");
        } else {
            System.out.println ("The rectangles do not intersect, test passed.");
        }

        StdDraw.setPenColor(Color.RED); //smaller rectangle
        one.show();
        StdDraw.setPenColor(Color.BLUE);
        two.show();
    } //end of main


} //end of Rectangle class
