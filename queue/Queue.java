package queue;
/*
    need:
    parameter:
        size
        front
        rear
    functions:
        enqueue
        dequeue
        isFull
        isEmpty
*/

public class Queue<type> {
    int front, rear, maxSize, currSize;
    type arr[];
    
    public Queue (int maxSize) {
        front = rear = -1;
        this.maxSize = maxSize;
        this.arr = (type[])(new Object[maxSize]);
    }

    public boolean isEmpty () {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void enqueue (type value) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }else if (isEmpty()) {
            front = rear = 0;
        }else {
            rear++;
        }
        arr[rear] = value;
    }

    public type dequeue () {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }else if (rear == front){
            front = rear = -1;
            return null;
        }else {
            type value = arr[front];
            front++;
            return value;
        }
    }

    @Override
    public String toString () {
        if (isEmpty())
            return "";
        
        String text = "";
        for (int idx = front; idx <= rear; idx++) {
            text += arr[idx];
            if (idx != rear) {
                text += " | ";
            }
        }
        return text;
    }
}
