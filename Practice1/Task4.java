import java.util.Scanner;

public class Task4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String testString = "2? + ?5 = 69";


    }

    static MyOperator sum = (int a, int b) -> a+b;
    static MyOperator reduction = (int a, int b) -> a-b;
    static MyOperator product = (int a, int b) -> a*b;
    static MyOperator division = (int a, int b) -> a*b;
    public static byte[] parseStringToInt(String numInString){ // -1 replaces ? - variable value
        int depth = numInString.length();
        byte[] result = new byte[depth];
        for (int i = 0; i < depth; i++) {
            
        }
    }
    private static int[] findPossibleNumbers(int[] operand1, int[] operand2, int[] result, MyOperator operation){

        return new int[] {operation.apply(a, b)};
    }
    public interface MyOperator {
        int apply(int a, int b);
    }


}