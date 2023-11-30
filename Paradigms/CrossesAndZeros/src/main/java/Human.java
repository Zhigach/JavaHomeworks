import java.util.Scanner;

public class Human extends Player{
    Scanner scanner;
    public Human(String name, Symbol smb, Scanner scanner) {
        super(name, smb);
        this.scanner = scanner;
    }

    public int doTurn() {
        int x, y;
        System.out.println("Enter coordinate to put your mark:");
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;
        return y*3 + x;
    }
}
