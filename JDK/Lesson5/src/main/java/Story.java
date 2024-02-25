import java.util.ArrayList;
import java.util.List;

public class Story {
    public static void main(String[] args) {
        RoundTable table = new RoundTable();


        List<Philosopher> philosophers = new ArrayList<>();
        philosophers.add(new Philosopher("Lao Chi", table));
        philosophers.add(new Philosopher("Zi Hoo", table));
        philosophers.add(new Philosopher("Ma Lin", table));
        philosophers.add(new Philosopher("Jackie Chan", table));
        philosophers.add(new Philosopher("Little Pony", table));



        for (Philosopher philosopher : philosophers) {
            new Thread(philosopher).start();
        }
    }
}
