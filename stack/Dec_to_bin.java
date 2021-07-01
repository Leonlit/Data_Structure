package stack;

import java.util.Scanner;

public class Dec_to_bin {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        String numberInString = input.nextLine();

        ArrayStack stack = new ArrayStack(16);
        int number = stringToInt(numberInString);

        while (number > 0) {
            String chr = Integer.toString(number % 2);
            stack.push(chr);
            number /= 2;
        }

        stack.printStackContent();
        stack.printStackContentReversed();
        input.close();
        String test = stack.pop();
        System.out.println(test);
        stack.printStackContent();
        stack.printStackContentReversed();
        stack.printStackContentVertically();
    }

    public static int stringToInt(String number ) {
        return Integer.parseInt(number);
    }
}