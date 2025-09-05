// //4. Hands on
// Create a  class Point2D   for representing a point in x & y(int) co-ordinate system.
// (Tight encapsulation please !)
// 4.1 Create a parameterized constructor to accept x & y co-ords.
// 4.2 Add  show() method  --to return point's x & y co-ords
// 4.3 
// Add a non static  , isEqual method to Point2D class : boolean returning method : must return true if both points are having same x,y co-ords or false otherwise.
// Hint - Ask yourself - 
// How will you invoke it from the tester ?
// 4.4 
// Add a non static method , calculateDistance , to calc distance between 2 points
// Hint : use distance formula.
// Hint - Ask yourself - 
// How will you invoke it from the tester ?
// 4.5  Create a separate Driver(main)  class(for UI )  , "TestPoint" , with main(..)
// 4.6  Accept x,y co-ordinates for 2 points & store the co-ordinates
// 4.7  Display x,y co-ordinates of both of the points plotted  (using show() method)
// 4.8  (OPTIONAL WORK)
// Find out if the points  are same or different (Hint : isEqual)
// Print the message accordingly. (print SAME or DIFFERENT)
// If points are not same , display distance between these 2 points.
package com.developer.geometry;
public class Point2D{
    private int x;
    private int y;

    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String show() {
        return "Point(" + x + ", " + y + ")";
    }


    public boolean isEqual(Point2D other) {
        return this.x == other.x && this.y == other.y;
    }

    
    public double calculateDistance(Point2D other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}