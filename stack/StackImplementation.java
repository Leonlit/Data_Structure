public class StackImplementation {
    public static void main (String args[]) {
        String str = "test123456123456789011";
        ArrayStack stack = new ArrayStack(str.length());
        for (int idx = 0;idx < str.length();idx++) {
            stack.push(Character.toString(str.charAt(idx)));
        }

        stack.printStackContent();
        stack.printStackContentVertically();

        stack.pop();
        stack.printStackContent();
        stack.printStackContentVertically();

        String str2 = "test123456123456789011";
        LinkedStack stack2 = new LinkedStack(str2.length());
        for (int idx = 0;idx < str2.length();idx++) {
            stack2.push(Character.toString(str2.charAt(idx)));
        }

        stack2.printStackContent();
        stack2.pop();
        stack2.printStackContent(); 
    }
}