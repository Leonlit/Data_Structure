import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitTesting {
    @Test
    public void testLinkedListCreationAndPushing () {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(1));
        list.pushNode(new Node<Integer>(2));
        list.pushNode(new Node<Integer>(0));
        
        assertEquals(list.toString(), "1 -> 2 -> 0");
    }

    @Test
    public void testEmptyHeadPush() {
        LinkedList<Integer> list = new LinkedList<Integer>(null);

        Node<Integer> newNode = new Node<Integer>(1);
        list.pushNode(newNode);

        newNode = new Node<Integer>(2);
        list.pushNode(newNode);

        assertEquals(list.toString(), "1 -> 2");
    }

    @Test
    public void testLinkedListHead () {
        LinkedList<Integer> list = new LinkedList<Integer>(null);
        assertTrue(list.isHeadNull());

        list = new LinkedList<Integer>(new Node<Integer>(1));
        assertFalse(list.isHeadNull());
    }

    @Test
    public void testNodeInserts() {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(0));

        list.insertNode(new Node<Integer>(1), 1);
        list.insertNode(new Node<Integer>(2), 1);
        list.insertNode(new Node<Integer>(3), 2);

        assertEquals(list.toString(), "0 -> 2 -> 3 -> 1");
        assertEquals(list.getSize(), 4);

        LinkedList<Integer> list_2 = new LinkedList<Integer>(null);
        list_2.insertNode(new Node<Integer>(1), 0);

        assertEquals(list_2.getSize(), 1);
        assertEquals(list_2.toString(), "1");
    }

    @Test
    public void testUnshiftList() {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(1));
        list.unshiftList(new Node<Integer>(5));

        assertEquals(list.toString(), "5 -> 1");
        assertEquals(list.getSize(), 2);

        list = new LinkedList<Integer>(null);
        list.unshiftList(new Node<Integer>(5));

        assertEquals(list.getSize(), 1);
        assertEquals(list.toString(), "5");
    }

    @Test
    public void testShiftList() {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(1));
        Node<Integer> newNode = new Node<Integer>(5);
        list.pushNode(newNode);
        list.shiftList();
        assertEquals(list.toString(), "5");

        list = new LinkedList<Integer>(null);
        assertEquals(list.toString(), "");
    }

    @Test
    public void testPopNode() {
        Node<Integer> initialHeadNode = new Node<Integer>(1);
        LinkedList<Integer> list = new LinkedList<Integer>(initialHeadNode);
        list.popNode();
        
        assertEquals(list.toString(), "");

        list.pushNode(initialHeadNode);
        list.pushNode(new Node<Integer>(5));
        list.pushNode(new Node<Integer>(2));
        assertEquals(list.getSize(), 3);
        list.popNode();
        assertEquals(list.getSize(), 2);
        assertEquals(list.toString(), "1 -> 5");
    }

    @Test
    public void testDeleteNode () {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(0));

        list.pushNode(new Node<Integer>(1));
        list.pushNode(new Node<Integer>(2));
        list.pushNode(new Node<Integer>(3));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(5));

        assertEquals(list.toString(), "0 -> 1 -> 2 -> 3 -> 4 -> 5");
        assertEquals(list.getSize(), 6);

        list.deleteNode(2);
        assertEquals(list.toString(), "0 -> 1 -> 3 -> 4 -> 5");
        assertEquals(list.getSize(), 5);
        list.deleteNode(0);
        assertEquals(list.toString(), "1 -> 3 -> 4 -> 5");
        assertEquals(list.getSize(), 4);
        list.deleteNode(3);
        assertEquals(list.toString(), "1 -> 3 -> 4");
        assertEquals(list.getSize(), 3);
    }

    @Test
    public void testDeleteSpecific () {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(0));
        list.pushNode(new Node<Integer>(3));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(8));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(9));

        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 4 -> 4 -> 9");

        list.deleteSpecificValue(4);
        list.printList();
        assertEquals(list.toString(), "0 -> 3 -> 8 -> 9");
    }

    @Test
    public void testDeleteDuplicate () {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(0));
        list.pushNode(new Node<Integer>(3));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(8));
        list.pushNode(new Node<Integer>(9));
        list.pushNode(new Node<Integer>(4));
        list.pushNode(new Node<Integer>(8));
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 4 -> 8 -> 9 -> 4 -> 8");

        list.removeDuplicate();
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 9");
    }

    @Test
    public void testReverseList() {
        LinkedList<Integer> list = new LinkedList<Integer>(new Node<Integer>(0));

        list.pushNode(new Node<Integer>(1));
        list.pushNode(new Node<Integer>(2));
        list.pushNode(new Node<Integer>(3));
        list.iterateReverseList();

        assertEquals(list.toString(), "3 -> 2 -> 1 -> 0");

        list.iterateReverseList();
        assertEquals(list.toString(), "0 -> 1 -> 2 -> 3");

        list.recursivelyReverseList(null);
        assertEquals(list.toString(), "3 -> 2 -> 1 -> 0");
        list.recursivelyReverseList(null);
        assertEquals(list.toString(), "0 -> 1 -> 2 -> 3");
    }
    
}
