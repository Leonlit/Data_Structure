package linkedList;

public class LinkedListImplementation {
    public static void main (String args[]) {
        //creating new LinkedList<Integer> Object
        System.out.println("Creating Linked list");
        LinkedList<Integer> list = new LinkedList<Integer>(1);
        list.pushNode(2);
        list.pushNode(0);
        list.printList();

        //pushing elements when the head is empty (initialy)
        System.out.println("Pushing data into Linked list");
        list = new LinkedList<Integer>(null);
        list.pushNode(1);
        list.pushNode(2);
        list.printList();

        //Inserting elements into specific location
        System.out.println("Inserting data into Linked list");
        list = new LinkedList<Integer>(0);
        list.insertNode(1, 1);
        list.insertNode(2, 1);
        list.insertNode(3, 2);
        list.printList();
        //testing if empty head will also work or not
        LinkedList<Integer> list_2 = new LinkedList<Integer>(null);
        list_2.printList();
        list_2.insertNode(1, 0);
        list_2.printList();

        System.out.println("Unshifting data into Linked list");
        //testing unshifting (adding to the front of the list)
        list = new LinkedList<Integer>(1);
        list.unshiftList(5);
        list.printList();

        list = new LinkedList<Integer>(null);
        list.unshiftList(5);
        list.printList();

        System.out.println("shifting a Linked list");
        //testing shifting (removing element from the front)
        list = new LinkedList<Integer>(1);
        Integer newNode = 5;
        list.pushNode(newNode);
        list.shiftList();
        list.printList();

        list = new LinkedList<Integer>(null);
        list.printList();
    
        System.out.println("Popping out a element from a Linked list");
        //testing popping element from the last position
        Integer initialHeadNode = 1;
        list = new LinkedList<Integer>(initialHeadNode);
        list.popNode();
        list.printList();

        list.pushNode(initialHeadNode);
        list.pushNode(5);
        list.pushNode(2);
        list.printList();
        list.popNode();
        list.printList();

        //Deleting an element from Linked list
        System.out.println("Deleting an element from Linked list");
        list = new LinkedList<Integer>(0);

        list.pushNode(1);
        list.pushNode(2);
        list.pushNode(3);
        list.pushNode(4);
        list.pushNode(5);
        list.printList();

        list.deleteNode(2);
        list.printList();
        list.deleteNode(0);
        list.printList();
        list.deleteNode(3);
        list.printList();
        
    //Reversing a LinkedList<Integer>
    System.out.println("Reversing a Linked list using iteration");
    list = new LinkedList<Integer>(0);

    list.pushNode(1);
    list.pushNode(2);
    list.pushNode(3);
    list.iterateReverseList();

    list.printList();

    list.iterateReverseList();
    list.printList();

    System.out.println("Reversing a Linked list using recursion");
    list.recursivelyReverseList(null);
    list.printList();
    list.recursivelyReverseList(null);
    list.printList();
    }
}