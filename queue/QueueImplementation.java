package queue;

public class QueueImplementation {
    public static void main(String[] args) {
        /* 
        //normal queue
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
        System.out.println(test.toString());
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
        System.out.println(test.toString()); 
        */

        /* 
        //linkedList queue
        QueueLinkedList<Integer> linkedListQueue = new QueueLinkedList<Integer>(20);
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(20);
        System.out.println(linkedListQueue.toString());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue()); 
        */

        //Circular queue
        CircularQueue<Integer> test = new CircularQueue<Integer>(10);
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
        System.out.println(test.toString());
        for (int idx = 0; idx < 10;idx++)
            System.out.println(test.dequeue());
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
        System.out.println(test.dequeue());
        System.out.println(test.toString());

    }
}