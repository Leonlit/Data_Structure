public class LinkedStack<T> {
    private int size, index, contentWidth;
    private Node<T> head;

    public LinkedStack (int size, T top) {
        this.size = size;
        this.head = new Node<T>(top);
        this.push(top);
    }

    public LinkedStack (int size) {
        this.size = size;
    }

    public void push (T character) {
        if (this.isFull()) {
            System.out.println("Error, the stack is full");
        }else {
            if (character.toString().length() > this.contentWidth) {
                this.contentWidth = character.toString().length();
            }
            if (isEmpty()) {
                this.head = new Node<T>(character);
            }else {
                Node<T> temp = new Node<T>(character);
                temp.setNextNode(this.head);
                this.head = temp;
            }
            this.index++;
        }
    }

    public Node<T> pop () {
        if (!this.isEmpty()) {
            this.index--;
            System.out.println("\nPopped out " + this.head.getValue());
            Node<T> temp = this.head;
            this.head = this.head.getNextNode();
            return temp;
        }
        return null;
    }

    public Node<T> top () {
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
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.getValue() + " -> ");
            curr = curr.getNextNode();
        }
        System.out.println();
    }
}

class Node<T> {
    private Node<T> next;
    private T value;

    public Node (T value) {
        this.value = value;
    }

    public Node (Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node<T> getNextNode() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

    public void setNextNode (Node<T> newNode) {
        this.next = newNode;
    }

    public void updateValue (T newValue) {
        this.value = newValue;
    }
}