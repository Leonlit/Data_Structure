package queue;


public class CircularQueue<type> {
    int front, rear, maxSize;
    type arr[];

    @SuppressWarnings("unchecked")
    public CircularQueue (int maxSize) {
        front = rear = -1;
        arr = (type[])new Object[maxSize];
        this.maxSize = maxSize;
    }

    public boolean isEmpty () {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return ((front == 0 && rear == maxSize - 1) ||
      (rear == (front - 1) % (maxSize - 1)));
    }

    public void enqueue (type value) {
        if (isFull()) {
            System.out.println("The queue is Full");
            return;
        }else if (isEmpty()) {
            front = rear = 0;
        } else if (rear == maxSize - 1 && front != 0){
            rear = 0;
        }else {
            rear++;
        }
        arr[rear] = value;
    }

    public type dequeue () {
        if (isEmpty()) {
            System.out.println("The queue is empty");
            return null;
        }
        
        type value = arr[front];

        if (front == rear) {
            front = rear = -1;
        }else if (front == maxSize - 1) {
            front = 0;
        }else {
            front++;
        }

        return value;
    }

    public String toString() {
        if (isEmpty()) {
            System.out.println("Waiting List is empty");
            return "";
        } else {
            String value = "";
            if (rear >= front) {
                //if the index has not become a loop print them normally
                for (int idx = front;idx <= rear;idx++) {
                    value += arr[idx];
                    if (idx != rear) 
                        value += " | ";
                }
            }else {
                for (int idx = front;idx < maxSize;idx++) {
                    value += arr[idx];
                    if (idx != rear) 
                        value += " | ";
                }
                for (int idx = 0;idx <= rear;idx++) {
                    value += arr[idx];
                    if (idx != rear) 
                        value += " | ";
                }
            }
            return value;
        }
    }
}
