public class LinkedListImplementation {
    public static void main (String args[]) {
        Node initialHeadNode = new Node(1);
        LinkedList list = new LinkedList(initialHeadNode);
        Node newNode = new Node (2);
        list.pushNode(newNode);
        newNode = new Node (0);
        list.insertNode(newNode, 2);
        list.printList();
        list.shiftList();
        list.printList();
    }
}