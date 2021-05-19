public class ArrayStack {
    private int size, index, contentWidth;
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
            if (character.length() > this.contentWidth) {
                this.contentWidth = character.length();
            }
            this.stack[this.index] = character;
            this.index++;
        }
    }

    public String pop () {
        if (!this.isEmpty()) {
            this.index--;
            System.out.println("\nPopped out " + this.stack[this.index]);
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
        for (int idx=0;idx<(this.size * (this.contentWidth + 3) + 1);idx++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printStackContentVertically () {
        System.out.println("\nStack contents vertically\n");
        if (this.isFull()) {
            verticalBaseBorder();
        }
        printEmptyVerticalSpace(this.size, this.index);
        for (int idx=this.index - 1;idx >= 0;idx--) {
            System.out.println("| " + this.stack[idx] + " |");
            verticalBaseBorder();
        }
    }

    public void printStackContentReversedVertically () {
        
    }

    private void printEmptyVerticalSpace (int size, int index) {
        String spaces = "";
        for (int idx=0;idx<contentWidth + 2;idx++) {
            spaces += " ";
        }
        for (int idx=0;idx< (size - index);idx++) {
            System.out.println("|" + spaces + "|");
            verticalBaseBorder();
        }
    }

    private void verticalBaseBorder () {
        for (int hor=0;hor < this.contentWidth * 3 + 2;hor++) {
            System.out.print("-");
        }
        System.out.println();
    }

}