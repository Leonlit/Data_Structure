import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UnitTesting {
    @Test
    public void testLinkedListCreationAndPushing () {
        Node initialHeadNode = new Node(1);
        LinkedList list = new LinkedList(initialHeadNode);

        Node newNode = new Node (2);
        list.pushNode(newNode);
        
        newNode = new Node(0);
        list.pushNode(newNode);
        
        assertEquals(list.toString(), "1 -> 2 -> 0");
    }

    @Test
    public void testEmptyHeadPsh() {
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

        Node initialHeadNode = new Node(1);
        list = new LinkedList(initialHeadNode);
        assertFalse(list.isHeadNull());
    }

    @Test
    public void testNodeInserts() {
        Node initialHeadNode = new Node(0);
        LinkedList list = new LinkedList(initialHeadNode);

        Node newNode = new Node(1);
        list.insertNode(newNode, 1);

        newNode = new Node(2);
        list.insertNode(newNode, 1);

        assertEquals(list.toString(), "0 -> 2 -> 1");
    }

    @Test
    public void testNodeInsertsEmptyHead() {
        LinkedList list = new LinkedList(null);

        Node newNode = new Node(1);
        list.insertNode(newNode, 0);

        assertEquals(list.toString(), "");
    }
}
