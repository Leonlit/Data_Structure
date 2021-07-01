package queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Integer> test = new Queue<Integer>(10);
        test.enqueue(10);
        test.enqueue(20);
        test.enqueue(50);
        test.enqueue(30);
        test.enqueue(40);
        test.enqueue(70);
        test.enqueue(60);
        test.enqueue(80);
        test.enqueue(100);
        test.enqueue(90);
        test.enqueue(-1);
        for (int idx = 0; idx < 10;idx++)
            test.dequeue();
        test.enqueue(20);
        test.enqueue(50);
        test.enqueue(30);
        test.enqueue(40);
        test.enqueue(70);
        test.enqueue(60);
        test.enqueue(80);
        test.enqueue(100);
        test.enqueue(90);
        test.enqueue(-1);
        test.dequeue();
        test.printQueue();
    }
}