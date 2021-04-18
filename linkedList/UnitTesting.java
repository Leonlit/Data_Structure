import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitTesting {
    @Test
    public void testLinkedListCreationAndPushing () {
        LinkedList list = new LinkedList(new Node(1));
        list.pushNode(new Node (2));
        list.pushNode(new Node(0));
        
        assertEquals(list.toString(), "1 -> 2 -> 0");
    }

    @Test
    public void testEmptyHeadPush() {
        LinkedList list = new LinkedList(null);

        Node newNode = new Node (1);
        list.pushNode(newNode);

        newNode = new Node(2);
        list.pushNode(newNode);

        assertEquals(list.toString(), "1 -> 2");
    }

    @Test
    public void testLinkedListHead () {
        LinkedList list = new LinkedList(null);
        assertTrue(list.isHeadNull());

        list = new LinkedList(new Node(1));
        assertFalse(list.isHeadNull());
    }

    @Test
    public void testNodeInserts() {
        LinkedList list = new LinkedList(new Node(0));

        list.insertNode(new Node(1), 1);
        list.insertNode(new Node(2), 1);
        list.insertNode(new Node(3), 2);

        assertEquals(list.toString(), "0 -> 2 -> 3 -> 1");
        assertEquals(list.getSize(), 4);

        LinkedList list_2 = new LinkedList(null);
        list_2.insertNode(new Node(1), 0);

        assertEquals(list_2.getSize(), 1);
        assertEquals(list_2.toString(), "1");
    }

    @Test
    public void testUnshiftList() {
        LinkedList list = new LinkedList(new Node(1));
        list.unshiftList(new Node(5));

        assertEquals(list.toString(), "5 -> 1");
        assertEquals(list.getSize(), 2);

        list = new LinkedList(null);
        list.unshiftList(new Node(5));

        assertEquals(list.getSize(), 1);
        assertEquals(list.toString(), "5");
    }

    @Test
    public void testShiftList() {
        LinkedList list = new LinkedList(new Node(1));
        Node newNode = new Node(5);
        list.pushNode(newNode);
        list.shiftList();
        assertEquals(list.toString(), "5");

        list = new LinkedList(null);
        assertEquals(list.toString(), "");
    }

    @Test
    public void testPopNode() {
        Node initialHeadNode = new Node(1);
        LinkedList list = new LinkedList(initialHeadNode);
        list.popNode();
        
        assertEquals(list.toString(), "");

        list.pushNode(initialHeadNode);
        list.pushNode(new Node(5));
        list.pushNode(new Node(2));
        assertEquals(list.getSize(), 3);
        list.popNode();
        assertEquals(list.getSize(), 2);
        assertEquals(list.toString(), "1 -> 5");
    }

    @Test
    public void testDeleteNode () {
        LinkedList list = new LinkedList(new Node(0));

        list.pushNode(new Node(1));
        list.pushNode(new Node(2));
        list.pushNode(new Node(3));
        list.pushNode(new Node(4));
        list.pushNode(new Node(5));

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
        LinkedList list = new LinkedList(new Node(0));
        list.pushNode(new Node(3));
        list.pushNode(new Node(4));
        list.pushNode(new Node(8));
        list.pushNode(new Node(4));
        list.pushNode(new Node(4));
        list.pushNode(new Node(9));

        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 4 -> 4 -> 9");

        list.deleteSpecificValue(4);
        list.printList();
        assertEquals(list.toString(), "0 -> 3 -> 8 -> 9");
    }

    @Test
    public void testDeleteDuplicate () {
        LinkedList list = new LinkedList(new Node(0));
        list.pushNode(new Node(3));
        list.pushNode(new Node(4));
        list.pushNode(new Node(4));
        list.pushNode(new Node(8));
        list.pushNode(new Node(9));
        list.pushNode(new Node(4));
        list.pushNode(new Node(8));
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 4 -> 8 -> 9 -> 4 -> 8");

        list.removeDuplicate();
        assertEquals(list.toString(), "0 -> 3 -> 4 -> 8 -> 9");
    }

    @Test
    public void testReverseList() {
        LinkedList list = new LinkedList(new Node(0));

        list.pushNode(new Node(1));
        list.pushNode(new Node(2));
        list.pushNode(new Node(3));
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
