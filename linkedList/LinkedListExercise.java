import java.util.HashSet;

/*
    Linked List Assignment
    1)Given list of 2 -> 3 -> 4 -> 8 -> 9,
        a)Delete node contain 4
        b)Delete node at position 3

    2)Given list of 2 -> 3 -> 4 -> 8 -> 9
        a)Insert new node contains 4 after node position 3.
        b)Given that you don’t know wether there is a duplicate, write a removeDuplicates() 
          function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
          Suggestions: Use two loops, one to go through the nodes, another loop (inner loop) to compare between
          the nodes data.
*/

public class LinkedListExercise {
	public static void main (String args[]) {
        //question 1
        System.out.println("\n\nQuestion 1\n");
        LinkedList list = new LinkedList(new Node(2));
        list.pushNode(new Node(3));
        list.pushNode(new Node(4));
        list.pushNode(new Node(8));
        list.pushNode(new Node(9));
        list.printList();

        list.deleteSpecificValue(4);
        list.printList();

        list.deleteNode(2);
        list.printList();

        //Question 2
        System.out.println("\n\nQuestion 2\n");
        list = new LinkedList(new Node(2));
        list.pushNode(new Node(3));
        list.pushNode(new Node(4));
        list.pushNode(new Node(8));
        list.pushNode(new Node(9));
        list.printList();

        list.insertNode(new Node(4), 3);
        list.printList();

        list = removeDuplicate(list);
        list.printList();

	}
    
    public static LinkedListSmall removeDuplicate (LinkedListSmall list) {
        HashSet<Integer> hash = new HashSet<>();
        Node current = list.getHead();
        Node prev = null;
        while (current != null) {
            int currValue = current.getValue();

            if (hash.contains(currValue)) {
                prev.setNextNode(current.getNextNode());
            }else {
                hash.add(currValue);
                prev = current;
            }
            current = current.getNextNode();
        }
        return list;
    }
}

class Node {
    private Node next;
    private int value;

    public Node (int value) {
        this.value = value;
    }

    public Node (Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNextNode() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNextNode (Node newNode) {
        this.next = newNode;
    }

    public void updateValue (int newValue) {
        this.value = newValue;
    }
	
}

class LinkedListSmall {
    private Node head;
    private int size;

    public LinkedListSmall (Node head) {
        if (head != null) {
            this.size = 1;
        }
        this.head = head;
    }

    public Node getHead () {
        return this.head;
    }

    public boolean isHeadNull() {
        boolean headNull = this.head == null;
        if (headNull) {
            System.out.println("Linked list is empty!");
        }
        return headNull;
    }

    //adding a node to the last position of the list
    public void pushNode (Node newNode) {
        if (newNode != null) {
            if (isHeadNull()) {
                this.head = newNode;
            }else {
                Node current = this.head;
                while (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
                current.setNextNode(newNode);
            }
            this.size++;
        }else {
            warningNullParam();
        }
    }

    //inserting node into certain position (within the size of the new list)
    public void insertNode (Node newNode, int pos) {
        if (newNode == null) {
            warningNullParam();
        }else {
            if (pos < 0) {
                pos = size - Math.abs(pos + 1);
            }
            if (pos - 1 > size || pos < 0) {
                System.out.println("Position " + pos + " out of list's boundary");
            }else {
                if (pos == 0) {
                    unshiftList(newNode);
                }else {
                    Node currentNode = this.head;
                    for (int x = 0; x < pos - 1; x++) {
                        currentNode = currentNode.getNextNode();
                    }
                    newNode.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(newNode);
                    this.size++;
                }
            }
        }
    }

    //unshifting the list (adding node to index 0)
    public void unshiftList (Node newNode) {
        if (newNode != null) {
            newNode.setNextNode(this.head);
            this.head = newNode;
            this.size++;
        }else {
            warningNullParam();
        }
    }

    //shifting the list (removing the first node)
    public void shiftList () {
        if (!isHeadNull()) {
            this.head = this.head.getNextNode();
            this.size--;
        }
    }

    //removing a node a from a specific position
    public void deleteNode (int pos) {
        if (pos > size || pos < 0) {
            System.out.println("Position " + pos + " out of list's boundary");
        }else {
            if (!isHeadNull()) {
                Node prev = this.head;
                for (int index = 0; index < pos - 1; index++) {
                    prev = prev.getNextNode();
                }
                Node current = prev.getNextNode();
                if (pos == 0 ){
                    shiftList();
                }else {
                    Node next = current.getNextNode();
                    prev.setNextNode(next);
                    this.size--;
                }
            }
        }
    }

    public void deleteSpecificValue(int value) {
        Node prev = null;
        Node current = this.head;
        while (current != null) {
            if (current.getValue() == value) {
                if (prev == null) {
                    this.head = current.getNextNode();
                }else {
                    prev.setNextNode(current.getNextNode());
                }
            }else {
                prev = current;
            }
            current = current.getNextNode();
        }
    }

    //printing out the linkedlist in a customized way
    public void printList() {
        if (!isHeadNull()) {
            System.out.println(toString());
        }
    }

    private void warningNullParam () {
        System.out.println("Warning, The value given into the method is null!");
    }

    //overriding the toString() method
    @Override
    public String toString () {
        String list = "";
        if (!isHeadNull()) {
            Node current = this.head;
            while (current != null) {
                list = list + current.getValue();
                current = current.getNextNode();
                if (current != null) list += " -> ";
            }
        }
        return list;
    }
}
