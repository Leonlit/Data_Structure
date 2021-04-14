public class LinkedList {
    private Node head;
    private int size;

    public LinkedList (Node head) {
        if (head != null) {
            this.size = 1;
        }
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

    //removing a node a the last position
    public void popNode () {
        if (!isHeadNull()) {
            if (this.size == 1) {
                shiftList();
                return;
            }
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
                if (pos == 0 ){
                    this.head = this.head.getNextNode();
                }else {
                    Node next = current.getNextNode();
                    prev.setNextNode(next);
                }
                this.size--;
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