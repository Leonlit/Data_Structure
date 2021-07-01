package linkedList;

public class Node<Type> {
    private Node<Type> next;
    private Type value;

    public Node (Type value) {
        this.value = value;
    }

    public Node (Node<Type> next, Type value) {
        this.next = next;
        this.value = value;
    }

    public Node<Type> getNextNode() {
        return this.next;
    }

    public Type getValue() {
        return this.value;
    }

    public void setNextNode (Node<Type> newNode) {
        this.next = newNode;
    }

    public void updateValue (Type newValue) {
        this.value = newValue;
    }
}