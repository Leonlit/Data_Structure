import java.util.Scanner;

class NameInCharArray {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        printStringWithDelays("\nWelcome user, please input your name and I'll print it out again:");
        String name = input.nextLine();
        input.close();
        char arr[] = name.toCharArray();

        printStringWithDelays("Re-printing your name, give me a moment");
        printStringWithDelays("\nOh so you're ");
        printWithDelays(arr);

        printStringWithDelays("\nNice to meet you.");
        printStringWithDelays("\nOk, that's all bye....");
        System.out.println();
    }

    static void printStringWithDelays (String text) {
        printWithDelays(text.toCharArray());
    }

    static void printWithDelays (char characters[]) {
        for (char alphabets: characters) {
            try {
                Thread.sleep(50);
                System.out.print(alphabets);
            }catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}