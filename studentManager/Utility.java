package studentManager;

public class Utility {
    static public void separatorStart(){
        System.out.println("\n");
        separator();
    }

    static public void separator() {
        for (int x = 0; x < 100 ; x++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    static public void separatorEnd() {
        separator();
        System.out.println("\n");
    }

    static public void clearScreen () {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    static public void pauseSystem () {
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
    }
}
