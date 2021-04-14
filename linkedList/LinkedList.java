public class LinkedList {
    private Node head;
    private int size = 1;

    public LinkedList (Node head) {
        this.head = head;
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
    }

    //inserting node into certain position (within the size of the new list)
    public void insertNode (Node newNode, int pos) {
        if (!isHeadNull()) {
            if (pos < 0) {
                pos = size - Math.abs(pos + 1);
            }
            size++;
            if (pos > size || pos < 0) {
                size--;
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
                }
            }
        }
    }

    //unshifting the list (adding node to index 0)
    public void unshiftList (Node newNode) {
        if (newNode != null) {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }else {
            System.out.println("Can't add null into the list");
        }
    }

    //shifting the list (removing the first node)
    public void shiftList () {
        if (!isHeadNull()) {
            this.head = this.head.getNextNode();
            size--;
        }
    }

    //removing a node a the last position
    public void popNode () {
        if (!isHeadNull()) {
            Node current = this.head;
            while (current.getNextNode() != null) {
                Node nextNode = current.getNextNode();
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
                Node prev = this.head;
                for (int index = 0; index < pos - 1; index++) {
                    prev = prev.getNextNode();
                }
                Node current = prev.getNextNode();
                if (current.getNextNode() == null) {
                    prev.setNextNode(null);
                }else if (pos == 0 ){
                    this.head = this.head.getNextNode();
                }else {
                    Node next = current.getNextNode();
                    prev.setNextNode(next);
                    this.size--;
                }
            }
            
        }
    }

    //reversing linked list using iterative method
    public void iterateReverseList() {
        if (!isHeadNull()) {
            Node curr, next, prev;
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

    public void recursivelyReverseList (Node curr) {
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