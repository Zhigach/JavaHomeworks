import java.util.ArrayList;
import java.util.List;

public class RoundTable {
    private static int countForks = 0;
    List<Fork> forks = new ArrayList<>();
    List<Philosopher> philosophers = new ArrayList<>();
    private void addFork() {
        forks.add(new Fork(countForks++));
    }
    public RoundTable() {
        addFork();
        addFork();
        addFork();
        addFork();
        addFork();
    }

    public boolean isForkTaken(int forkNumber) {
        return forks.get(forkNumber).isTaken();
    }
    private int getPhilosophersIndex(Philosopher philosopher) {
        return philosophers.indexOf(philosopher);
    }
    private Fork getFork(int forkNumber) {
        return forks.get(forkNumber);
    }
    public Fork getLeftFork(Philosopher philosopher) {
        int forkIndex = getPhilosophersIndex(philosopher) % philosophers.size();
        if (isForkTaken(forkIndex)) {
            throw new IllegalStateException("Fork is already taken");
        }
        Fork fork = getFork(forkIndex);
        fork.setTaken(true);
        return fork;
    }
    public Fork getRightFork(Philosopher philosopher) {
        int forkIndex = (getPhilosophersIndex(philosopher) + 1 ) % philosophers.size();
        if (isForkTaken(forkIndex)) {
            throw new IllegalStateException("Fork is already taken");
        }
        Fork fork = getFork(forkIndex);
        fork.setTaken(true);
        return fork;
    }
    public void putForkBack(Fork fork) {
        if (forks.contains(fork))
            fork.setTaken(false);
        else
            throw new IllegalArgumentException("Your fork is not from this table.");
    }
    public void addPhilosopher(Philosopher philosopher) {
        philosophers.add(philosopher);
    }
}
