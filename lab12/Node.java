/*----------------------------------------------------------------
 *  Author:   L.King
 *  Email:    lking@holycross.edu
 *  Written:  7/27/2015
 *
 *----------------------------------------------------------------*/

public class Node {

    public int val;
    public Node next;

    public Node() {
        val = 0;
        next = null;
    }

    public Node(int v) {
        val = v;
        next = null;
    }

    public Node(int v, Node n) {
        val = v;
        next = n;
    }

    public String toString() {
        return String.format("Node @ %p { val = %d, next = %p }", this, val, next);
    }

} // Node Class
