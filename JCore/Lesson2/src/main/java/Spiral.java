/**
 4*. Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив в виде инкременированной цепочки чисел, идущих по спирали.
 */
public class Spiral {
    static boolean isAvailable(int[][] mat, int r, int c){ // treats 0 as available (not used) cells
        return (r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 0);
    }

    public static int[][] Fill2dMatrixSpiral(int a, int b){
        int[][] mat = new int[a][b];
        int counter = 1;
        int i = 0;
        int j = 0;
        int deli = 0;
        int delj = 1;
        mat[i][j] = counter;
        while (true){
            while (isAvailable(mat, i+deli, j+delj)){
                i += deli;
                j += delj;
                mat[i][j] = ++counter;
            }
            if (isAvailable(mat, i, j+1)){
                deli = 0;
                delj = 1;
            } else if (isAvailable(mat, i+1, j)){
                deli = +1;
                delj = 0;
            } else if (isAvailable(mat, i, j-1)){
                deli = 0;
                delj = -1;
            } else if (isAvailable(mat, i-1, j)){
                deli = -1;
                delj = 0;
            } else
                break;
        }
        return mat;
    }

    static void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] < 10) {
                    System.out.print(" " + mat[i][j] + " ");
                } else {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMatrix(Fill2dMatrixSpiral(3,4));
    }
}
