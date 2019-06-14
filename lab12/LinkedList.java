/*----------------------------------------------------------------
 *
 *----------------------------------------------------------------*/

public class LinkedList {

    public Node head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(String filename) {
        head = null;

        In inputStream = new In(filename);

        Node last = null;
        Node newItem = null;

        while (!inputStream.isEmpty()) {
            int val = inputStream.readInt();

            // Create a node to hold this value
            newItem = new Node(val);

            if (head == null) {  
                head = newItem;
            } //insert in empty list       
            else { 
                last.next = newItem;
            } //insert at the end

            // Advance last pointer to point at the new item
            last = newItem;
        } // while more items to insert

        inputStream.close();
    }

    public String toString() {
        return String.format("LinkedList { head = %p }", head);
    }

    public void print() {
        System.out.print("[");
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.val);
            curr = curr.next;
        } // still items left to print
        System.out.println(" ]");
    } // end of print

    public void insertFront(int val) {
        if (head == null) {  
            head = new Node(val);
        } // list is empty, so make the head be that value
        else { 
            Node temp = head;
            head = new Node(val);
            head.next = temp;
        } // insert new value at the front
    } // end of insertFront

    public void insertRear(int val) {
        if (head == null) {  
            head = new Node(val);
        } // list is empty, so make the head be that value
        else { 
            Node curr = head;
            while (curr.next != null) { 
                curr = curr.next;
            } // find the end of the list
            // insert the new node
            curr.next = new Node(val);
        } // insert at the end
    } // end of insertRear

    public void insertOrdered(int newVal) {
        // TODO: Fill this in

    } //insertOrdered


    public boolean contains(int targetVal) {
        // TODO: Fill this in

        return false;
    } // end of contains()

} // end of LinkedList Class
