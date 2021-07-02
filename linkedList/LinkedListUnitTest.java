package linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class LinkedListUnitTest {
    @Test
    public void testLinkedListCreationAndPushing () {
        LinkedList<Integer> list = new LinkedList<Integer>(1);
        list.pushNode(2);
        list.pushNode(0);
        
        assertEquals(list.toString(), "1 -> 2 -> 0");
    }

    @Test
    public void testEmptyHeadPush() {
        LinkedList<Integer> list = new LinkedList<Integer>(null);

        Integer newNode = 1;
        list.pushNode(newNode);

        newNode = 2;
        list.pushNode(newNode);

        assertEquals(list.toString(), "1 -> 2");
    }

    @Test
    public void testLinkedListHead () {
        LinkedList<Integer> list = new LinkedList<Integer>(null);
        assertTrue(list.isHeadNull());

        list = new LinkedList<Integer>(1);
        assertFalse(list.isHeadNull());
    }

    @Test
    public void testNodeInserts() {
        LinkedList<Integer> list = new LinkedList<Integer>(0);

        list.insertNode(1, 1);
        list.insertNode(2, 1);
        list.insertNode(3, 2);

        assertEquals(list.toString(), "0 -> 2 -> 3 -> 1");
        assertEquals(list.getSize(), 4);

        LinkedList<Integer> list_2 = new LinkedList<Integer>(null);
        list_2.insertNode(1, 0);

        assertEquals(list_2.getSize(), 1);
        assertEquals(list_2.toString(), "1");
    }

    @Test
    public void testUnshiftList() {
        LinkedList<Integer> list = new LinkedList<Integer>(1);
        list.unshiftList(5);

        assertEquals(list.toString(), "5 -> 1");
        assertEquals(list.getSize(), 2);

        list = new LinkedList<Integer>(null);
        list.unshiftList(5);

        assertEquals(list.getSize(), 1);
        assertEquals(list.toString(), "5");
    }

    @Test
    public void testShiftList() {
        LinkedList<Integer> list = new LinkedList<Integer>(1);
        Integer newNode = 5;
        list.pushNode(newNode);
        list.shiftList();
        assertEquals(list.toString(), "5");

        list = new LinkedList<Integer>(null);
        assertEquals(list.toString(), "");
    }

    @Test
    public void testPopNode() {
        Integer initialHeadNode = 1;
        LinkedList<Integer> list = new LinkedList<Integer>(initialHeadNode);
        list.popNode();
        
        assertEquals(list.toString(), "");

        list.pushNode(initialHeadNode);
        list.pushNode(5);
        list.pushNode(2);
        assertEquals(list.getSize(), 3);
        list.popNode();
        assertEquals(list.getSize(), 2);
        assertEquals(list.toString(), "1 -> 5");
    }

    @Test
    public void testDeleteNode () {
        LinkedList<Integer> list = new LinkedList<Integer>(0);

        list.pushNode(1);
        list.pushNode(2);
        list.pushNode(3);
        list.pushNode(4);
        list.pushNode(5);

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
        LinkedList<Integer> list = new LinkedList<Integer>(0);
        list.pushNode(3);
        list.pushNode(4);
        list.pushNode(8);
        list.pushNode(4);
        list.pushNode(4);
        list.pushNode(9);

        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 4 -> 4 -> 9");

        list.deleteSpecificValue(4);
        list.printList();
        assertEquals(list.toString(), "0 -> 3 -> 8 -> 9");
    }

    @Test
    public void testDeleteDuplicate () {
        LinkedList<Integer> list = new LinkedList<Integer>(0);
        list.pushNode(3);
        list.pushNode(4);
        list.pushNode(4);
        list.pushNode(8);
        list.pushNode(9);
        list.pushNode(4);
        list.pushNode(8);
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 4 -> 8 -> 9 -> 4 -> 8");

        list.removeDuplicate();
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 9");
    }

    @Test
    public void testReverseList() {
        LinkedList<Integer> list = new LinkedList<Integer>(0);

        list.pushNode(1);
        list.pushNode(2);
        list.pushNode(3);
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
