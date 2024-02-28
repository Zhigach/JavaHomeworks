import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    static final List<GameResult> results = new ArrayList<>();
    static final int DOORS_NUMBER = 3;
    boolean[] doorsContentIsWinning = new boolean[DOORS_NUMBER];
    int winningDoorNumber;
    boolean[] doorIsDiscovered = new boolean[DOORS_NUMBER];
    Random rand;
    Monti monti;
    @Setter
    Player player;
    Game(Player player) {
        rand = new Random(System.currentTimeMillis());
        winningDoorNumber = rand.nextInt(DOORS_NUMBER);
        doorsContentIsWinning[winningDoorNumber] = true;
        this.player = player;
        player.setGame(this);
        this.monti = new Monti(this);
    }

    public void start() {
        int initialChoice = player.chooseDoorFirstStep();
        doorIsDiscovered[initialChoice] = true;
        int montiDiscoveredDoor = monti.openAnotherDoor(winningDoorNumber, initialChoice);
        int secondPlayerTry = player.rechooseDoor(montiDiscoveredDoor);
        results.add(new GameResult(secondPlayerTry == winningDoorNumber));
    }

    public String presentResults() {
        double wins = results.stream().filter(GameResult::hasWon).count();
        String result =  String.format("Player tactic was %s. Win percentage is %s%%", player.getPlayerTactic(), wins/results.size()*100);
        clearResults();
        return result;
    }
    public void clearResults() {
        results.clear();
    }
}
