public class ArrayStack {
    private int size;
    private int index;
    private String stack[];

    public ArrayStack (int size, String top) {
        this.size = size;
        this.stack = new String[size];
        this.push(top);
    }

    public ArrayStack (int size) {
        this.size = size;
        this.stack = new String[size];
    }

    public void push (String character) {
        if (this.isFull()) {
            System.out.println("Error, the stack is full");
        }else {
            this.stack[this.index] = character;
            this.index++;
        }
    }

    public String pop () {
        if (!this.isEmpty()) {
            this.index--;
            System.out.println("Popped out " + this.stack[this.index]);
            return this.stack[index];
        }
        return null;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public boolean isFull() {
        return index == size;
    }

    public void printStackContent () {
        System.out.println("\nStack Contents: ");
        horizontalBorder();
        System.out.print("| ");
        for (int idx= 0 ; idx<this.index; idx++) {
            System.out.print(this.stack[idx] + " | ");
        }
        System.out.println();
        horizontalBorder();
    }

    public void printStackContentReversed () {
        System.out.println("\nStack Contents in reverse: ");
        horizontalBorder();
        System.out.print("| ");
        for (int idx= index - 1 ; idx >= 0; idx--) {
            System.out.print(this.stack[idx] + " | ");
        }
        System.out.println();
        horizontalBorder();
    }
    
    public void horizontalBorder() {
        for (int idx=0;idx<(size * 4 + 1);idx++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printStackContentVertically () {
        
    }

    public void printStackContentReversedVertically () {
        
    }

}