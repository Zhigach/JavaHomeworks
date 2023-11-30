public abstract class Player {
    String name;
    final Symbol smb;

    public String getName() {
        return name;
    }

    public Symbol getSmb() {
        return smb;
    }

    public abstract int doTurn();

    public Player(String name, Symbol smb) {
        this.name = name;
        this.smb = smb;
    }
}
