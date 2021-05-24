public class LinkedStack {
    private int size, index, contentWidth;
    private Node head;

    public LinkedStack (int size, String top) {
        this.size = size;
        this.head = new Node(top);
        this.push(top);
    }

    public LinkedStack (int size) {
        this.size = size;
    }

    public void push (String character) {
        if (this.isFull()) {
            System.out.println("Error, the stack is full");
        }else {
            if (character.length() > this.contentWidth) {
                this.contentWidth = character.length();
            }
            if (isEmpty()) {
                this.head = new Node(character);
            }else {
                Node temp = new Node(character);
                temp.setNextNode(this.head);
                this.head = temp;
            }
            this.index++;
        }
    }

    public Node pop () {
        if (!this.isEmpty()) {
            this.index--;
            System.out.println("\nPopped out " + this.head.getValue());
            Node temp = this.head;
            this.head = this.head.getNextNode();
            return temp;
        }
        return null;
    }

    public Node top () {
        return head;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public void printStackContent () {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return ;
        }
        System.out.println("\nStack Contents: ");
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.getValue() + " -> ");
            curr = curr.getNextNode();
        }
        System.out.println();
    }
}

class Node {
    private Node next;
    private String value;

    public Node (String value) {
        this.value = value;
    }

    public Node (Node next, String value) {
        this.next = next;
        this.value = value;
    }

    public Node getNextNode() {
        return this.next;
    }

    public String getValue() {
        return this.value;
    }

    public void setNextNode (Node newNode) {
        this.next = newNode;
    }

    public void updateValue (String newValue) {
        this.value = newValue;
    }
}