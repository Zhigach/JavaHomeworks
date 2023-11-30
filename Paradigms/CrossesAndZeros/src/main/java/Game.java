public class Game {
    final Player player1;
    final Player player2;
    Player winner = null;
    Field field = new Field();
    boolean finished = false;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        System.out.println("\nNOTE!\nField coordinates are named as follows:\n  1 2 3\n1| | | |\n2| | | |\n3| | | |\n\n");
        System.out.println("Game started!");
        while (!finished) {
            takeTurn(player1);
            checkStatus(player1);
            if (finished)
                break;
            takeTurn(player2);
            checkStatus(player2);
        }
        finish(winner);
    }

    public void finish(Player player) {
        System.out.printf("%s wins!\n", player.getName());
    }

    private void takeTurn(Player player) {
        int index = player.doTurn();;
        while (!isValidPoint(index)) {
            if (player instanceof Human){
                System.out.println("Invalid coordinate, try again!");
            }
            index = player.doTurn();
        }
        field.setValue(index, player.getSmb());
        field.print();
    }

    private boolean isValidPoint(int index) {
        if (index < 0 || index > 8) {
            return false;
        }
        if (field.getValue(index) != Symbol.EMPTY)
            return false;
        return true;
    }

    public void checkStatus(Player player) {
        if (field.hasFinishedRow(player.getSmb())) {
            winner = player;
            finished = true;
        }
    }
}
