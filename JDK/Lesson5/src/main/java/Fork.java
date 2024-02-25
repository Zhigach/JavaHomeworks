public class Fork {
    int number;
    private boolean isTaken = false;

    public Fork(int number) {
        this.number = number;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTaken() {
        return isTaken;
    }
}
