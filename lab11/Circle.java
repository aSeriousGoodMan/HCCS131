/*----------------------------------------------------------------
 *  Author:   Z.Lucas
 *  Email:    lking@holycross.edu
 *  Written:  7/14/2015
 *
 *  Implements the Rectangle methods described on page 406.
 *
 *  Rectangle class instance variables:
 *    The x, y coordinates indicate the center of the rectangle.
 *    The width and height keep track of the size.
 *    And isFilled indicates whether or not it should be drawn as filled
 *              or as just an outline.
 *  Methods include area(), perimeter(), contains(), intersects(),
 *                  show(), and toString().
 *  A main function is also included, as an example and for testing purposes.
 *
 *  Example: java Rectangle
 *----------------------------------------------------------------*/

import java.awt.Color;

public class Circle {

    private final double x;         // x,y is the center point of this rectangle
    private final double y;	
    private final double radius;     // width and height are the lengths of this rectangle's sides
    private final boolean isFilled; // whether this rectangle should be filled in when drawn

    public Circle(double x0, double y0, double r, boolean fill) {
        x = x0;
        y = y0;
        radius = r;
        isFilled = fill;
    } //constructor

    public double area() {
        return (Math.pow(radius, 2.0)) * (Math.PI);
    } //area

    public double perimeter() {
        return 2 * radius * Math.PI;
    } //perimeter

    public boolean intersects(Circle b) {
 
        //boolean horizontal = Math.abs(this.x - b.x) <= (this.width + b.width) / 2;
        //olean vertical = Math.abs(this.y - b.y) <= (this.height + b.height) / 2;

        // The use of "this" is optional nearly everywhere. In the above two
        // lines, we could write simply "x" instead of "this.x", for example.
        // But in the following statement, we must use "this" as the parameter
        // when we call b's "contains()" method. We also include "this" when
        // writing "this.contains(b)" because it looks more clear than omitting
        // the "this" and writing only "contains(b)".
        // From page 433 of your textbook:
        //    Java provides the this keyword to give us a way to refer
        //    within the code of an instance method to the object whose
        //    name was used to in voke this method. You can use this
        //    in code in the same way you use any other name. Some Java
        //    programmers always use this to refer to instance variables.
        return false; //horizontal && vertical && !(this.contains(b) || b.contains(this));

    } //intersects

    public boolean contains(Circle b) {
	double distance = Math.sqrt(Math.pow(this.x - b.x, 2.0) + Math.pow(this.y - b.y, 2.0));
        double radiusDiff  = this.radius - b.radius;
	if(distance < Math.abs(radiusDiff)) {
		return true;
	    }else{
	    return false;
	}
    } //contains

    public void show() {
        // We divide by 2 below, because the StdDraw rectangle-drawing functions
        // use half-width and half-height.
        if (isFilled) {
            StdDraw.filledCircle(x, y, width / 2, height / 2);
        } else {
	    // StdDraw.circle(x, y, area /2);
        }
    } //show

    public String toString() {
        return String.format(
			   "Rectangle at (%.3f, %.3f) with width %.3f and height %.3f",
			   x, y, width, height);
    } //toString

    // This main function is meant for testing purposes, and to serve as
    // an example of how to use Circle objects.
    public static void main(String[] args) {
        Circle  a = new Circle(0.25, 0.5, 0.25, true);
        StdOut.println("a is: " + a);
        StdOut.println("a's area is: " + a.area());
        StdOut.println("a's perimeter is: " + a.perimeter());
        a.show();
    } //main

} //end of Rectangle class
