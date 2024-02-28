import org.apache.commons.collections.CollectionUtils;

import java.util.Random;
import java.util.Set;

public class Monti {
    Random rand;
    Game game;
    public Monti(Game game) {
        this.game = game;
        rand = new Random(System.currentTimeMillis());
    }
    public int openAnotherDoor(int winningDoor, int playersChoice) {
        Set<Integer> dflt = Set.of(0,1,2);
        if (winningDoor == playersChoice) {
            return (Integer) CollectionUtils.subtract(dflt, Set.of(winningDoor)).toArray()[rand.nextInt(2)];
        }
        return (Integer) CollectionUtils.subtract(dflt, Set.of(winningDoor, playersChoice)).toArray()[0];
    }
}
