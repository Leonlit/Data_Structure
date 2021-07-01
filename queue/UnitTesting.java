package queue;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitTesting {
    @Test
    public void testNormalQueue () {
        Queue<Integer> queue = new Queue<Integer>(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.enqueue(-1);
        assertEquals(queue.toString(), "10 | 20 | 50 | 30 | 40 | 70 | 60 | 80 | 100 | 90");
        assertTrue(queue.isFull());

        for (int idx = 0; idx < 10;idx++)
            queue.dequeue();
        assertEquals(queue.toString(), "");
        assertTrue(queue.isEmpty());
        
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.enqueue(-1);
        queue.dequeue();
        assertEquals(queue.toString(), "50 | 30 | 40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertTrue(queue.isFull());

        assertEquals(queue.dequeue(), (Integer)50);
        assertEquals(queue.dequeue(), (Integer)30);
        assertEquals(queue.toString(), "40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testLinkedListQueue () {
        QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.enqueue(-1);
        assertEquals(queue.toString(), "10 | 20 | 50 | 30 | 40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());

        for (int idx = 0; idx < 11;idx++)
            queue.dequeue();
        assertEquals(queue.toString(), "");
        assertTrue(queue.isEmpty());
        
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.enqueue(-1);
        queue.dequeue();
        assertEquals(queue.toString(), "50 | 30 | 40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());

        assertEquals(queue.dequeue(), (Integer)50);
        assertEquals(queue.dequeue(), (Integer)30);
        assertEquals(queue.toString(), "40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());
    }

    @Test 
    public void testCircularQueue () {
        CircularQueue<Integer> queue = new CircularQueue<Integer>(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.dequeue();
        queue.enqueue(-1);
        System.out.println(queue.toString());
        assertEquals(queue.toString(), "20 | 50 | 30 | 40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());

        for (int idx = 0; idx < 10;idx++)
            queue.dequeue();
        assertEquals(queue.toString(), "");
        assertTrue(queue.isEmpty());
        
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.enqueue(80);
        queue.enqueue(100);
        queue.enqueue(90);
        queue.dequeue();
        queue.enqueue(-1);
        queue.dequeue();
        assertEquals(queue.toString(), "30 | 40 | 70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());

        assertEquals(queue.dequeue(), (Integer)30);
        assertEquals(queue.dequeue(), (Integer)40);
        assertEquals(queue.toString(), "70 | 60 | 80 | 100 | 90 | -1");
        assertFalse(queue.isEmpty());
    }
}
