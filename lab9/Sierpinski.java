/*----------------------------------------------------------------
 *  Author:
 *  Email:
 *  Written:
 *  
 *  Draw a Sierpinksi triangle using recursion.
 *
 *  Example: java Sierpinski 5
 *----------------------------------------------------------------*/
public class Sierpinski {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Oops, you should provide exactly one argument, like this:");
            System.out.println("  java Sierpinski 3");
            System.exit(1);
        }
        int levels = Integer.parseInt(args[0]);  //Number of levels to draw
        StdOut.printf("Drawing a Sierpinski Gasket with %d levels\n", levels);
        StdDraw.setXscale(0, 120);               //Scale the drawing window
        StdDraw.setYscale(0, 120);
        drawSierpinski(10, 10, 100, levels);     //Draw Sierpinski Gasket
    }

    //*********************************************************************
    //drawSierpinski(x, y, size, levels)
    //Purpose: Draw a Sierpinski Gasket at position (x, y) in the drawing
    //    window, outer sidelength given by size, and number of levels
    //    given by levels.
    //*********************************************************************
    public static void drawSierpinski(double x, double y, 
            double size, int levels) {

        if (levels == 0 ) {                    //Base case
            return;
        }else{                                 //General case
            // FIXME:
            // Add a print statement to print out the level.
           
            // FIXME:
            // Add code here to Draw outer triangle.
            // Use the drawTriangle( ) function defined below.
	     double topx = x + Math.cos(Math.toRadians(60.0))*size;
	     double topy = y + Math.sin(Math.toRadians(60.0))*size;

	    
	    drawTriangle(x, y, size);
	    drawSierpinski(x, y, size/2, levels - 1);
	    drawSierpinski(x +size/2, y, size/2, levels - 1);
	    drawSierpinski((x+topx)/2,(y + topy)/2, size/2, levels - 1);
	    

            // FIXME:
            // Add code here for creating three more smaller gaskets
            // of one less level the three corners of the outer triangle.
            // Think recursion!
            // You will need the coordinates for each of these small gaskets.
            // Hint: Look at drawTriangle for computing x and y coordinates of the
            // upper tip of the triangle
        }
    }

    //*********************************************************************
    //drawTriangle(x, y, size)
    //Purpose: Draw a triangle with sidelength given by size and with
    //    lower left corner at position (x, y)
    //*********************************************************************
    public static void drawTriangle(double x, double y, double size) {
        //Compute the position of the top of the triangle
        double topx = x + Math.cos(Math.toRadians(60.0))*size;
        double topy = y + Math.sin(Math.toRadians(60.0))*size;
        //Create arrays for the x and y components of the three vertices
        double[] verticesX = {x, x+size, topx};
        double[] verticesY = {y, y, topy};
        //Use StdDraw to draw a triangle
        StdDraw.polygon(verticesX, verticesY);
    }
}
