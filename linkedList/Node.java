class Node {
    private Node next;
    private int value;

    public Node (int value) {
        this.value = value;
    }

    public Node (Node next, int value) {
        this.next = next;
        this.value = value;
    }

    public Node getNextNode() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNextNode (Node newNode) {
        this.next = newNode;
    }

    public void updateValue (int newValue) {
        this.value = newValue;
    }
}