public class Field {
    private Symbol[] field = new Symbol[9];

    public Field() {
        for (int i = 0; i < 9; i++) {
            field[i] = Symbol.EMPTY;
        }
    }

    public boolean setValue(int index, Symbol smb) {
        if (index < 0 || index > 8) {
            return false;
        }
        if (field[index] != Symbol.EMPTY)
            return false;
        field[index] = smb;
        return true;
    }
    public Symbol getValue(int index) {
        return field[index];
    }
    public void print() {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                switch (field[i*3 + j]){
                    case ZERO -> System.out.print(" o ");
                    case CROSS -> System.out.print(" x ");
                    case EMPTY -> System.out.print("  ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("- - - - - -");
    }
    public boolean hasFinishedRow(Symbol smb) {

        for (int i = 0; i < 3; i++) {
            if (field[i] == smb && field[i+3] == smb && field[i+6] == smb)
                return true;
        }

        for (int i = 0; i < 7; i+=3) {
            if (field[i] == smb && field[i+1] == smb && field[i+2] == smb)
                return true;
        }

        if (field[0] == smb && field[4] == smb && field[8] == smb)
            return true;

        if (field[2] == smb && field[4] == smb && field[6] == smb)
            return true;

        return false;
    }
}
