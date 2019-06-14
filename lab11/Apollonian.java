/*----------------------------------------------------------------
 *  Email:    lking@holycross.edu
 *  Written:  8/15/2015
 *
 *  Creates a "random" Apollonian-like Fractal drawing using the
 *  Circle class.
 *  An Apollonian gasket (net) is a fractal generated from triples 
 *  of circles, where each circle is tangent to the other two. 
 *  It is named after Greek mathematician Apollonius of Perga.
 *  This program creates a similar drawing, but the circles
 *  do not come in threes and just tries to be tangent.
 *
 *  Chooses an initial boundary circle that is centered in the drawing window,
 *  then fills this boundary with many random circles. The number of random
 *  circles is determined by the user from a command-line input. Each random
 *  circle is chosen to fill the largest amount of "free" space possible, i.e.
 *  space that isn't already occupied by any previously drawn circle. 
 *  
 *  Every circle drawn (except the boundary) is put into a list. The first one
 *  is chosen to have a random x, y coordinates and a random radius. The
 *  remaining circles are chosen to have random x, y coordinates and the largest
 *  possible radius without bumping into any of the other circles already in the
 *  list.
 *
 *  Usage:   java Apollonian Seed NumberOfCircles Filled?
 *  Example: java Apollonian 12345  1000 yes
 *  Example: java Apollonian 34233  1000 yes   
 *  Example: java Apollonian 354678 1000 no    //big circle
 *  Example: java Apollonian 8889 1000 no   
 *  Example: java Apollonian 8889 10 yes   
 *----------------------------------------------------------------*/

import java.awt.Color;
import java.util.Random;

public class Apollonian {

    // This variable determines how hard we try to find the largest circle that
    // will fit within the picture without touching any of the previous circles.
    // Higher numbers mean to try harder, lower numbers mean give up earlier.
    // The artwork is still fun if this number is lowered.  Performance is
    // affected if it is raised too much.
    // NOTE: When debugging, you might want to lower this to, say, 5 or 10, just
    // so that the program does less work.
    private static final int ACCURACY = 10000;

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Oops, you need to supply three command-line parameters:");
            System.out.println("a seed value, a count, then either \"yes\" or \"no\".\n");
            System.out.println("Here is an example with five filled circles:\n");
            System.out.println("  java Apollonian 12345 5 yes\n");
            System.exit(1);
        }

        // Create a random number generator and seed it with a number from the
        // command line arguments.
        int seed = Integer.parseInt(args[0]);
        Random rand = new Random(seed);
        System.out.println("Seed for random number generator will be: " + seed);

        // Get the number of requested circles from the command line arguments.
        int numCirclesToDraw = Integer.parseInt(args[1]);
        if (numCirclesToDraw < 1) {
            System.out.println("Oops, use at least 1 for number of circles to draw!");
            System.exit(1);
        }
        System.out.println("Number of circles to draw inside boundary: " + numCirclesToDraw);

        // Get the yes/no value of whether we should fill the circles from the
        // command line arguments.
        boolean isFilled = args[2].equalsIgnoreCase("yes");
        System.out.println("Drawing filled circles? " + isFilled);

        // Create and draw boundary circle circumscribed in the drawing window.
        Circle boundary = new Circle(.5, .5, .5, false);
        StdDraw.setPenColor(StdDraw.BLACK);
        boundary.show();

        // ----------------- start of artwork ------------------

        // The number of circles that have been drawn so far.
        int numDrawn = 0;

        // An array to hold all of the circles.
        //
        // Note: Elements 0 through (numDrawn - 1) will each contain valid
        // Circle objects that have already been drawn, but the remaining
        // elements of the array, numDrawn through (circles.length - 1), will be
        // empty (i.e. null).
        //
        // Also note: When adding a Circle to this list, you should make sure
        // that the new circle does not intersect (and is not contained inside
        // of, and does not itself contain) any of the circles already in this
        // list, and that it is fully contained inside the boundary circle too.
        Circle[] drawn = new Circle[numCirclesToDraw];

        // The first circle to draw is special. For this one, we just pick any
        // random x, y, and radius that fits within the boundary circle.  This
        // kind of "primes" the drawing.
        Circle first;
        do {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            double rad = rand.nextDouble();
            first = new Circle(x, y, rad, isFilled);
        } while (!boundary.contains(first));

        // Draw the first circle using a random color.
        StdDraw.setPenColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        first.show();

        // Add this first circle to the list of circles that have been drawn.
        drawn[numDrawn] = first;
        numDrawn++;

        System.out.println("First circle is: " + first);

        // Repeatedly draw more circles until we have enough.
        while (numDrawn < numCirclesToDraw) {
            System.out.println("Picking another circle...");

            // We want to find a circle that is as large as possible without
            // "intersecting" the border or a circle that was already drawn.
            // Finding the truly largest possible circle is mathematically
            // tricky. But we can do almost as well by just repeatedly picking
            // random large-ish circles and selecting the largest from among
            // these random circles.  We repeat this ACCURACY times. Using a
            // higher number for ACCURACY means we will very likely get close to
            // the true largest circle, but performance may suffer. Using a
            // lower number for ACCURACY will be faster, but our circles won't
            // always be completely "tangent" to each other as they should be.

            // Initialize the "largest so far" to be tiny. any random circle
            // chosen in the loop below will necessarily be larger than this.
            Circle currentLargest = new Circle(.5, .5, 0, isFilled); 

            // Now, repeatedly, try to find a bigger circles that fits.
            for(int tries = 0; tries < ACCURACY; tries++) {

                // Generate a random circle candidate, but with size 0.
                double x = rand.nextDouble();
                double y = rand.nextDouble();
                double rad = 0;
                Circle c = new Circle(x, y, rad, isFilled);

                // Check if that circle is properly contained in our boundary
                // circle. It has no radius, so we really this is only checking
                // if the center is within the boundary.
                boolean isValidCenter = boundary.contains(c);

                // TODO:
                // Now, check whether that circle is outside the circles that
                // have already been drawn (i.e. those stored in the array).
           

		// System.out.println("Center of " + c + " is valid? " + isValidCenter);

                // If the center is in "free" space, let's make the circle as
                // big as we can, little by little, until it intersects with
                // some other circle.
                if (isValidCenter) {
                    boolean intersects = false;
                    while (!intersects) {
                        rad = rad + .001;
                        c = new Circle(x, y, rad, isFilled);

                        // Check whether c interesects the boundary.
                        intersects = boundary.intersects(c);

                        // TODO:
                        // Check whether c intersects any of the circles that
                        // have already been drawn (i.e. those stored in the
                        // array).


			// System.out.println("After growing a little, does " + c  + " intersect? " + intersects);
                    } // end while loop

		    // System.out.println("After growing it is now " + c);

                    // TODO:
                    // Check if circle c is larger than the previous contender
                    // for the "largest so far". If so, then keep c as our new
                    // leading contender.
                
                
                } // end if the center was valid

            } // end finding a circle that's as big as possible

            System.out.println("Next circle is: " + currentLargest);
            Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            StdDraw.setPenColor(randomColor);
            // TODO:
            // Draw the largest found circle using the random color generated above.

            // TODO:
            // Add that circle to the list of circles that have been drawn.

        } // end of circle generating loop

    } // end of main function

} // end of class Apollonian
