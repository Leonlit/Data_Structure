package linkedList;

import java.util.HashSet;

/*
    Linked List Assignment
    1)Given list of 2 -> 3 -> 4 -> 8 -> 9,
        a)Delete NodeSmall contain 4
        b)Delete NodeSmall at position 3

    2)Given list of 2 -> 3 -> 4 -> 8 -> 9
        a)Insert new NodeSmall contains 4 after NodeSmall position 3.
        b)Given that you don’t know wether there is a duplicate, write a removeDuplicates() 
          function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.
          Suggestions: Use two loops, one to go through the nodes, another loop (inner loop) to compare between
          the nodes data.
*/

public class LinkedListExercise {
	public static void main (String args[]) {
        //question 1
        System.out.println("\n\nQuestion 1\n");
        LinkedListSmall list = new LinkedListSmall(new NodeSmall(2));
        list.pushNode(new NodeSmall(3));
        list.pushNode(new NodeSmall(4));
        list.pushNode(new NodeSmall(8));
        list.pushNode(new NodeSmall(9));
        list.printList();

        list.deleteSpecificValue(4);
        list.printList();

        list.deleteNode(2);
        list.printList();

        //Question 2
        System.out.println("\n\nQuestion 2\n");
        list = new LinkedListSmall(new NodeSmall(2));
        list.pushNode(new NodeSmall(3));
        list.pushNode(new NodeSmall(4));
        list.pushNode(new NodeSmall(8));
        list.pushNode(new NodeSmall(9));
        list.printList();

        list.insertNode(new NodeSmall(4), 3);
        list.printList();

        list = removeDuplicate(list);
        list.printList();

	}
    
    public static LinkedListSmall removeDuplicate (LinkedListSmall list) {
        HashSet<Integer> hash = new HashSet<>();
        NodeSmall current = list.getHead();
        NodeSmall prev = null;
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

class NodeSmall {
    private NodeSmall next;
    private int value;

    public NodeSmall (int value) {
        this.value = value;
    }

    public NodeSmall (NodeSmall next, int value) {
        this.next = next;
        this.value = value;
    }

    public NodeSmall getNextNode() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNextNode (NodeSmall newNode) {
        this.next = newNode;
    }

    public void updateValue (int newValue) {
        this.value = newValue;
    }
	
}

class LinkedListSmall {
    private NodeSmall head;
    private int size;

    public LinkedListSmall (NodeSmall head) {
        if (head != null) {
            this.size = 1;
        }
        this.head = head;
    }

    public NodeSmall getHead () {
        return this.head;
    }

    public boolean isHeadNull() {
        boolean headNull = this.head == null;
        if (headNull) {
            System.out.println("Linked list is empty!");
        }
        return headNull;
    }

    //adding a NodeSmall to the last position of the list
    public void pushNode (NodeSmall newNode) {
        if (newNode != null) {
            if (isHeadNull()) {
                this.head = newNode;
            }else {
                NodeSmall current = this.head;
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

    //inserting NodeSmall into certain position (within the size of the new list)
    public void insertNode (NodeSmall newNode, int pos) {
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
                    NodeSmall currentNode = this.head;
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

    //unshifting the list (adding NodeSmall to index 0)
    public void unshiftList (NodeSmall newNode) {
        if (newNode != null) {
            newNode.setNextNode(this.head);
            this.head = newNode;
            this.size++;
        }else {
            warningNullParam();
        }
    }

    //shifting the list (removing the first NodeSmall)
    public void shiftList () {
        if (!isHeadNull()) {
            this.head = this.head.getNextNode();
            this.size--;
        }
    }

    //removing a NodeSmall a from a specific position
    public void deleteNode (int pos) {
        if (pos > size || pos < 0) {
            System.out.println("Position " + pos + " out of list's boundary");
        }else {
            if (!isHeadNull()) {
                NodeSmall prev = this.head;
                for (int index = 0; index < pos - 1; index++) {
                    prev = prev.getNextNode();
                }
                NodeSmall current = prev.getNextNode();
                if (pos == 0 ){
                    shiftList();
                }else {
                    NodeSmall next = current.getNextNode();
                    prev.setNextNode(next);
                    this.size--;
                }
            }
        }
    }

    public void deleteSpecificValue(int value) {
        NodeSmall prev = null;
        NodeSmall current = this.head;
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
            NodeSmall current = this.head;
            while (current != null) {
                list = list + current.getValue();
                current = current.getNextNode();
                if (current != null) list += " -> ";
            }
        }
        return list;
    }
}
