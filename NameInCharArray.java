import java.util.Scanner;

class NameInCharArray {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("\nWelcome user, please input your name and I'll print it out again:");
        String name = input.nextLine();
        input.close();
        char arr[] = name.toCharArray();

        System.out.println("Re-printing your name, give me a moment");
        System.out.print("\nOh so you're ");
        for (char character: arr) {
            try {
                Thread.sleep(100);
                System.out.print(character);
            }catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

        System.out.println("\nNice to meet you.");
        System.out.println("\nOk, that's all bye....");
        System.out.println();
    }   
}