/**
 * Created by sennhviwang
 * Time: 11:08 AM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex13 {
    /**
     * initialize int array using StdRadom.uniform
     * @param a the name of int array
     * @param N the ceiling of random int number(not included)
     * @return return int array a
     */
    public static int[][] randomInitialIntArray(int[][] a,int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = StdRandom.uniform(N);
            }
        }
        return a;
    }

    /**
     * transpose array a
     * @param a the name of int array a
     * @param b the name of int array b
     * @return return int array b
     */
    public static int[][] transposeArray(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    /**
     * print transposed array a
     * @param a the name of int array a
     */
    public static void printTransposeArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                StdOut.print(a[i][j]);
            }
            StdOut.println();
        }
    }

    /**
     * main function.
     * @param args do nothing about args
     */
    public static void main(String[] args) {
        int m = 6;
        int n = 5;
        int[][] a = new int[m][n];
        int[][] b = new int[n][m];
        a = randomInitialIntArray(a,n);
        a = transposeArray(a,b);
        printTransposeArray(a);
    }
}
