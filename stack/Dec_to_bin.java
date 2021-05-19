import java.util.Scanner;

public class Dec_to_bin {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        String numberInString = input.nextLine();

        ArrayStack stack = new ArrayStack(32);
        int number = stringToInt(numberInString);

        while (number > 0) {
            char chr = Integer.toString(number % 2).charAt(0);
            stack.push(chr);
            number /= 2;
        }

        stack.printStackHorizontally();
        stack.printStackContent();
        input.close();
    }

    public static int stringToInt(String number ) {
        return Integer.parseInt(number);
    }
}