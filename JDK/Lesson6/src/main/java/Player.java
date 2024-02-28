import lombok.*;
import org.apache.commons.collections.CollectionUtils;

import java.util.Random;
import java.util.Set;

@Data
@Setter
@Getter
public class Player {
    Random rand;
    @Setter
    Game game;
    PlayerTactic playerTactic;
    int initialChoice;

    Player(PlayerTactic playerTactic) {
        rand = new Random(System.currentTimeMillis());
        this.playerTactic = playerTactic;
    }

    private int chooseNewDoor(int forbiddenDoor) {
        Set<Integer> dflt = Set.of(0, 1, 2);
        return (Integer) CollectionUtils.subtract(dflt, Set.of(initialChoice, forbiddenDoor)).toArray()[0];
    }
    public int chooseDoorFirstStep() {
        initialChoice = rand.nextInt(3);
        return initialChoice;
    }
    public int rechooseDoor(int anotherOpenedDoor) {
        switch (playerTactic) {
            case DO_NOT_CHANGE_CHOICE -> {
                return initialChoice;
            }
            case CHANGE_CHOICE -> {
                return chooseNewDoor(anotherOpenedDoor);
            }
            default -> {
                return -1;
            }
        }
    }
}
