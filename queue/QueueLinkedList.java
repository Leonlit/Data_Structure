package queue;

import linkedList.Node;

//almost the same as the normal Queue class, just that implemented using linkedList
public class QueueLinkedList<type> {
    Node<type> head;
    Node<type> tail;
    int size;

    public QueueLinkedList (type initial) {
        this.size = 0;
        enqueue(initial);
    }

    public void enqueue (type value) {
        if (value == null) {
            return;
        }
        if (isEmpty()) {
            this.head = new Node<type>(value);
            this.tail = this.head;
        }else {
            Node<type> temp = new Node<type>(value);
            this.tail.setNextNode(temp);
            this.tail = temp;
        }
    }

    public type dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return null;
        }else {
            Node<type> temp = this.head;
            this.head = this.head.getNextNode();
            return temp.getValue();
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString () {
        if (isEmpty()) {
            return "";
        }
        String value = "";
        Node<type> curr = this.head;
        value += curr.getValue();
        while (curr.getNextNode() != null) {
            curr = curr.getNextNode();
            value += " | " + curr.getValue();
        }
        return value;
    }
}
