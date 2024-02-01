package taskThree;

public class Main {
    public static void main(String[] args) {
        SubstituteSymbolInFile.substituteChar("out.txt", ',', '-');
        SubstituteSymbolInFile.substitutePhrase("out.txt", ", ", ",!");
    }
}
