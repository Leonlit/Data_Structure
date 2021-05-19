public class ArrayStack {
    private int size;
    private int index;
    private char stack[];

    public ArrayStack (int size, char top) {
        this.size = size;
        this.stack = new char[size];
        this.push(top);
    }

    public ArrayStack (int size) {
        this.size = size;
        this.stack = new char[size];
    }

    public void push (char character) {
        this.stack[this.index] = character;
        this.index++;
    }

    public char pop () {
        this.index--;
        return this.stack[index];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public void printStackHorizontally () {
        System.out.print("| ");
        for (int idx= 0 ; idx<this.index; idx++) {
            System.out.print(this.stack[idx] + " | ");
        }
        System.out.println();
    }

    public void printStackContent () {
        System.out.print("| ");
        for (int idx= index - 1 ; idx >= 0; idx--) {
            System.out.print(this.stack[idx] + " | ");
        }
        System.out.println();
    }

}