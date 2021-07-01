package linkedList;
import java.util.HashSet;

public class LinkedList<Type> {
    private Node<Type> head;
    private int size;
    Node<Type> temp;

    public LinkedList (Type initial) {
        if (initial != null) {
            if (this.head == null && initial != null) {
                this.size = 1;
            }
            temp = new Node<Type>(initial);
            this.head = temp;
        }
    }

    public Node<Type> getHead () {
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
    public void pushNode (Type newNode) {
        if (newNode != null) {
            temp = new Node<Type>(newNode);
            if (isHeadNull()) {
                this.head = temp;
            }else {
                Node<Type> current = this.head;
                while (current.getNextNode() != null) {
                    current = current.getNextNode();
                }
                current.setNextNode(temp);
            }
            this.size++;
        }else {
            warningNullParam();
        }
    }

    //inserting node into certain position (within the size of the new list)
    public void insertNode (Type newNode, int pos) {
        if (newNode == null) {
            warningNullParam();
        }else {
            if (pos < 0) {
                pos = size - Math.abs(pos + 1);
            }
            if (pos - 1 > size || pos < 0) {
                System.out.println("Position " + pos + " out of list's boundary");
            }else {
                temp = new Node<Type>(newNode);
                if (pos == 0) {
                    unshiftList(newNode);
                }else {
                    Node<Type> currentNode = this.head;
                    for (int x = 0; x < pos - 1; x++) {
                        currentNode = currentNode.getNextNode();
                    }
                    temp.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(temp);
                    this.size++;
                }
            }
        }
    }

    //unshifting the list (adding node to index 0)
    public void unshiftList (Type newNode) {
        if (newNode != null) {
            Node<Type> temp = new Node<Type>(newNode);
            temp.setNextNode(this.head);
            this.head = temp;
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

    //removing a node a the last position
    public void popNode () {
        if (!isHeadNull()) {
            if (this.size == 1) {
                shiftList();
                return;
            }
            Node<Type> current = this.head;
            while (current.getNextNode() != null) {
                Node<Type> nextNode = current.getNextNode();
                if (nextNode.getNextNode() == null) {
                    current.setNextNode(null);
                }else {
                    current = nextNode;
                }
            }
            this.size--;
        }
    }

    //removing a node a from a specific position
    public void deleteNode (int pos) {
        if (pos > size || pos < 0) {
            System.out.println("Position " + pos + " out of list's boundary");
        }else {
            if (!isHeadNull()) {
                Node<Type> prev = this.head;
                for (int index = 0; index < pos - 1; index++) {
                    prev = prev.getNextNode();
                }
                Node<Type> current = prev.getNextNode();
                if (pos == 0 ){
                    this.head = this.head.getNextNode();
                }else {
                    Node<Type> next = current.getNextNode();
                    prev.setNextNode(next);
                }
                this.size--;
            }
            
        }
    }

    //delete specific value from the linked list
    public void deleteSpecificValue(Type value) {
        Node<Type> prev = null;
        Node<Type> current = this.head;
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

    //remove duplicate values in linked list
    public void removeDuplicate () {
        if (!isHeadNull()) {
            HashSet<Type> hash = new HashSet<>();
            Node<Type> current = this.head;
            Node<Type> prev = null;
            while (current != null) {
                Type currValue = current.getValue();

                if (hash.contains(currValue)) {
                    prev.setNextNode(current.getNextNode());
                }else {
                    hash.add(currValue);
                    prev = current;
                }
                current = current.getNextNode();
            }
        }
    }

    //reversing linked list using iterative method
    public void iterateReverseList() {
        if (!isHeadNull()) {
            Node<Type> curr, next, prev;
            curr = this.head;
            prev = null;
            while (curr != null) {
                next = curr.getNextNode();
                curr.setNextNode(prev);
                prev = curr;
                curr = next;
            }
            this.head = prev;
        }
    }

    //recursively reversing a linkedlist
    public void recursivelyReverseList (Node<Type> curr) {
        if (curr == null) {
            curr = this.head;
        }
        if (curr.getNextNode() == null) {
            this.head = curr;
            return;
        }
        recursivelyReverseList(curr.getNextNode());
        curr.getNextNode().setNextNode(curr);
        curr.setNextNode(null);
    }

    //printing out the linkedlist in a customized way
    public void printList() {
        if (!isHeadNull()) {
            System.out.println(toString());
        }
    }

    public int getSize () {
        return this.size;
    }

    private void warningNullParam () {
        System.out.println("Warning, The value given into the method is null!");
    }

    //overriding the toString() method
    @Override
    public String toString () {
        String list = "";
        if (!isHeadNull()) {
            Node<Type> current = this.head;
            while (current != null) {
                list = list + current.getValue();
                current = current.getNextNode();
                if (current != null) list += " -> ";
            }
        }
        return list;
    }
}