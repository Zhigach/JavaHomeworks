import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!\nPlease, introduce yourself:");
        String guestName = scanner.nextLine();
        System.out.printf("\nHello, %s", guestName);

        Player p1 = new Human(guestName, Symbol.CROSS, scanner);
        Player p2 = new AI("Random robot", Symbol.ZERO);
        Game game = new Game(p1, p2);

        game.start();

        System.out.printf("\nGame finished. Thanks for playing, %s!", guestName);
    }
}
