/*----------------------------------------------------------------
 *  Author:   Z.Lucas
 *  Email:    lking@holycross.edu
 *  Written:  7/14/2015
 *
 *  Tests the Rectangle and Circle methods.
 *  Give a command line argument to determine which to test
 *
 *  Example: java Tester Circle
 *----------------------------------------------------------------*/

import java.awt.Color;


public class Tester {

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("CIRCLE")) {
                testCircle();
            } else if (args[0].equalsIgnoreCase("RECTANGLE")) {
                testRectangle();
            } else {
                System.err.println("Improper argument, can only accept \"Circle\" and \"Rectangle\".");
            }
        } else {
            System.err.println("At least one argment must be entered to determine which class should be tested.");
        }
    } //end of main

    private static void testCircle() {
        System.out.println("================================================");
        System.out.println("                Testing Circle                  ");
        System.out.println("================================================");

        Circle[] testC = new Circle[6];
        testC[0] = new Circle(.3, .5, .1, false);    // x, y, radius, filled?
        testC[1] = new Circle(.4, .5, .05, true);
        testC[2] = new Circle(.5, .5, .31, false);
        testC[3] = new Circle(.5, .4, .1, false);
        testC[4] = new Circle(.5, .7, .29, false);
        testC[5] = new Circle(.5, .8, .18, true);

        if (testC[4].contains(testC[5])) {
            System.out.println("Yellow contains Magenta, test passed");
        } else {
            System.err.println("Error: Yellow contains Magenta, test failed");
        }

        if (testC[2].contains(testC[0])) {
            System.out.println("Green contains Black, test passed");
        } else {
            System.err.println("Error: Green contains Black, test failed");
        }

        if (testC[2].contains(testC[1])) {
            System.out.println("Green contains Red, test passed");
        } else {
            System.err.println("Error: Green contains Red, test failed");
        }

        if (!testC[3].contains(testC[1])) {
            System.out.println("Blue not contains Green, test passed");
        } else {
            System.err.println("Error: Blue not contains Green, test failed");
        }

        if (!testC[4].contains(testC[0])) {
            System.out.println("Yellow not contains Black, test passed");
        } else {
            System.err.println("Error: Yellow not contains Black, test failed");
        }

        if (!testC[2].contains(testC[4])) {
            System.out.println("Green not contains Yellow, test passed");
        } else {
            System.err.println("Error: Green not contains Yellow, test failed");
        }

        if (testC[1].intersects(testC[3])) {
            System.out.println("Red intersects Blue, test passed");
        } else {
            System.err.println("Error: Red intersects Blue, test failed");
        }

        if (testC[0].intersects(testC[4])) {
            System.out.println("Black instersects Yellow, test passed");
        } else {
            System.err.println("Error: Black intersects Yellow, test failed");
        }

        if (testC[5].intersects(testC[2])) {
            System.out.println("Magenta intersects Green, test passed");
        } else {
            System.err.println("Error: Magenta intersects Green, test failed");
        }

        if (!testC[3].intersects(testC[5])) {
            System.out.println("Blue not intersects Magenta, test passed");
        } else {
            System.err.println("Error: Blue not intersects Magenta, test failed");
        }

        if (!testC[0].intersects(testC[3])) {
            System.out.println("Black not intersects Blue, test passed");
        } else {
            System.err.println("Error: Black not intersects Blue, test failed");
        }

        if (!testC[1].intersects(testC[4])) {
            System.out.println("Red not intersects Yellow, test passed");
        } else {
            System.err.println("Error: Red not intersects Yellow, test failed");
        }

        if (!testC[2].intersects(testC[3])) {
            System.out.println("Green not intersects Blue, test passed");
        } else {
            System.err.println("Error: Green not intersects Blue, test failed");
        }

        testC[0].show();
        StdDraw.setPenColor(Color.RED);
        testC[1].show();
        StdDraw.setPenColor(Color.GREEN);
        testC[2].show();
        StdDraw.setPenColor(Color.BLUE);
        testC[3].show();
        StdDraw.setPenColor(Color.YELLOW);
        testC[4].show();
        StdDraw.setPenColor(Color.MAGENTA);
        testC[5].show();
    } //test Circle class

    private static void testRectangle() {
        System.out.println("================================================");
        System.out.println("              Testing Rectangle                 ");
        System.out.println("================================================");

        Rectangle[] testR = new Rectangle[6];
        testR[0] = new Rectangle(.3, .5, .09, .3, false); // x, y, width, height, filled?
        testR[1] = new Rectangle(.4, .5, .3, .5, false);
        testR[2] = new Rectangle(.7, .5, .05, .4, true);
        testR[3] = new Rectangle(.5, .4, .09, .1, true);
        testR[4] = new Rectangle(.5, .7, .4, .19, false);
        testR[5] = new Rectangle(.5, .75, .8, .3, false);

        if (testR[5].contains(testR[4])) {
            System.out.println("Magenta contains Yellow, test passed");
        } else {
            System.err.println("Error: Magenta contains Yellow, test failed");
        }

        if (testR[1].contains(testR[0])) {
            System.out.println("Red contains Black, test passed");
        } else {
            System.err.println("Error: Red contains Black, test failed");
        }

        if (!testR[3].contains(testR[1])) {
            System.out.println("Blue not contains Red, test passed");
        } else {
            System.err.println("Error: Blue not contains Red, test failed");
        }

        if (!testR[1].contains(testR[2])) {
            System.out.println("Red not contains Green, test passed");
        } else {
            System.err.println("Error: Red not contains Green, test failed");
        }

        if (!testR[5].contains(testR[1])) {
            System.out.println("Magenta not contains Red, test passed");
        } else {
            System.err.println("Error: Magenta not contains Red, test failed");
        }

        if (testR[0].intersects(testR[4])) {
            System.out.println("Black intersects Yellow, test passed");
        } else {
            System.err.println("Error: Black intersects Yellow, test failed");
        }

        if (testR[5].intersects(testR[1])) {
            System.out.println("Magenta intersects Red, test passed");
        } else {
            System.err.println("Error: Magenta intersects Red, test failed");
        }

        if (testR[2].intersects(testR[4])) {
            System.out.println("Green intersects Yellow, test passed");
        } else {
            System.err.println("Error: Green intersects Yellow, test failed");
        }

        if (!testR[0].intersects(testR[3])) {
            System.out.println("Black not intersects Blue, test passed");
        } else {
            System.err.println("Error: Black not intersects Blue, test failed");
        }

        if (!testR[2].intersects(testR[1])) {
            System.out.println("Green not intersects Black, test passed");
        } else {
            System.err.println("Error: Green not intersects Black, test failed");
        }

        if (!testR[5].intersects(testR[4])) {
            System.out.println("Magenta not intersects Yellow, test passed");
        } else {
            System.err.println("Error: Magenta not intersects Yellow, test failed");
        }

        if (!testR[0].intersects(testR[1])) {
            System.out.println("Black not intersects Red, test passed");
        } else {
            System.err.println("Error: Black not intersects Red, test failed");
        }

        testR[0].show();
        StdDraw.setPenColor(Color.RED);
        testR[1].show();
        StdDraw.setPenColor(Color.GREEN);
        testR[2].show();
        StdDraw.setPenColor(Color.BLUE);
        testR[3].show();
        StdDraw.setPenColor(Color.YELLOW);
        testR[4].show();
        StdDraw.setPenColor(Color.MAGENTA);
        testR[5].show();
    } //test Rectangle class
} // end of Tester
