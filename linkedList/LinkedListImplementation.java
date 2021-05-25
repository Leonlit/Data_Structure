public class LinkedListImplementation {
    public static void main (String args[]) {
        //creating new LinkedList<Integer> Object
        System.out.println("Creating Linked list");
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(1));
        list.pushNode(new Node<Integer> (2));
        list.pushNode(new Node<Integer>(0));
        list.printList();

        //pushing elements when the head is empty (initialy)
        System.out.println("Pushing data into Linked list");
        list = new LinkedList<Integer>(null);
        list.pushNode(new Node<Integer> (1));
        list.pushNode(new Node<Integer>(2));
        list.printList();

        //Inserting elements into specific location
        System.out.println("Inserting data into Linked list");
        list = new LinkedList<Integer>(new Node<Integer>(0));
        list.insertNode(new Node<Integer>(1), 1);
        list.insertNode(new Node<Integer>(2), 1);
        list.insertNode(new Node<Integer>(3), 2);
        list.printList();
        //testing if empty head will also work or not
        LinkedList<Integer> list_2 = new LinkedList<Integer>(null);
        list_2.printList();
        list_2.insertNode(new Node<Integer>(1), 0);
        list_2.printList();

        System.out.println("Unshifting data into Linked list");
        //testing unshifting (adding to the front of the list)
        list = new LinkedList<Integer>(new Node<Integer>(1));
        list.unshiftList(new Node<Integer>(5));
        list.printList();

        list = new LinkedList<Integer>(null);
        list.unshiftList(new Node<Integer>(5));
        list.printList();

        System.out.println("shifting a Linked list");
        //testing shifting (removing element from the front)
        list = new LinkedList<Integer>(new Node<Integer>(1));
        Node<Integer> newNode = new Node<Integer>(5);
        list.pushNode(newNode);
        list.shiftList();
        list.printList();

        list = new LinkedList<Integer>(null);
        list.printList();
    
        System.out.println("Popping out a element from a Linked list");
        //testing popping element from the last position
        Node<Integer> initialHeadNode = new Node<Integer>(1);
        list = new LinkedList<Integer>(initialHeadNode);
        list.popNode();
        list.printList();

        list.pushNode(initialHeadNode);
        list.pushNode(new Node<Integer>(5));
        list.pushNode(new Node<Integer>(2));
        list.printList();
        list.popNode();
        list.printList();

        //Deleting an element from Linked list
        System.out.println("Deleting an element from Linked list");
        list = new LinkedList<Integer>(new Node<Integer>(0));

        list.pushNode(new Node<Integer>(1));
        list.pushNode(new Node<Integer>(2));
        list.pushNode(new Node<Integer>(3));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(5));
        list.printList();

        list.deleteNode(2);
        list.printList();
        list.deleteNode(0);
        list.printList();
        list.deleteNode(3);
        list.printList();
        
    //Reversing a LinkedList<Integer>
    System.out.println("Reversing a Linked list using iteration");
    list = new LinkedList<Integer>(new Node<Integer>(0));

    list.pushNode(new Node<Integer>(1));
    list.pushNode(new Node<Integer>(2));
    list.pushNode(new Node<Integer>(3));
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