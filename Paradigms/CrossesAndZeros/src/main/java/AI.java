import java.util.Random;

public class AI extends Player{
    @Override
    public int doTurn() {
        Random random = new Random();
        return random.nextInt(0,9);
    }

    public AI(String name, Symbol smb) {
        super(name, smb);
    }


}
