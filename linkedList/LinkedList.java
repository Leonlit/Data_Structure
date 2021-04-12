public class LinkedList {
    private Node head;
    private int size = 1;

    public LinkedList (Node head) {
        this.head = head;
    }

    private boolean isHeadNull() {
        boolean headNull = this.head == null;
        if (headNull) {
            System.out.println("Linked list is empty!");
        }
        return headNull;
    }

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
                    unshiftNode(newNode);
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

    public void unshiftNode (Node newNode) {
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void popNode() {
        if (!isHeadNull()) {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.getValue());
                current = current.getNextNode();
                if (current != null) System.out.print(" -> ");
            }
            System.out.println("");
        } 
    }

    public void printList() {
        if (!isHeadNull()) {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.getValue());
                current = current.getNextNode();
                if (current != null) System.out.print(" -> ");
            }
            System.out.println("");
        }
    }
}