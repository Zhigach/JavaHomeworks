public class Main {

    public static void main(String[] args) {
        Player  playerAlfa = new Player(PlayerTactic.DO_NOT_CHANGE_CHOICE);
        Game game = new Game(playerAlfa);
        for (int i = 0; i < 1000; i++) {
            game.start();
        }
        System.out.println(game.presentResults());

        Player  playerBravo = new Player(PlayerTactic.CHANGE_CHOICE);
        game.setPlayer(playerBravo);
        for (int i = 0; i < 1000; i++) {
            game.start();
        }
        System.out.println(game.presentResults());
    }
}
