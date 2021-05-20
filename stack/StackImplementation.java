public class StackImplementation {
    public static void main (String args[]) {
        String str = "test123456123456789011";
        ArrayStack stack = new ArrayStack(str.length());
        for (int idx = 0;idx < str.length();idx++) {
            stack.push(Character.toString(str.charAt(idx)));
        }

        stack.printStackContentReversed();
        stack.printStackContent();

        stack.pop();
        stack.printStackContent(); 
    }
}