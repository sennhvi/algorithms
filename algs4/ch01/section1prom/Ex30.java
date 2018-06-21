/**
 * Created by sennhviwang
 * Time: 2:05 AM on 5/18/15
 * Not trying to handle Exceptions.
 * Array exercise:
 * create a N*N boolean array.
 * when i and j are relatively prime,value of a[i][j] is true,otherwise it is false.
 */
public class Ex30 {
    /**
     * create boolean array with size of N * N,if i and j are relatively prime, assign its value true.
     * @param N length of array.
     * @return return boolean array.
     */
    public static boolean[][] createBoolArray(int N) {
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (gcd(i, j) == 1)
                    a[i][j] = true;
                else
                    a[i][j] = false;
            }
        }
        return a;
    }

    /**
     * great common divisor algorithm.
     * @param a No.1 number.
     * @param b No.2 number.
     * @return return gcd.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int r = a % b;
        return gcd(b, r);
    }

    /**
     * print boolean array.
     * @param a boolean array as input.
     */
    public static void printBoolArray(boolean[][] a) {
        int arrayLength = a.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                StdOut.printf(a[i][j] + "\t");
            }
            StdOut.println();
        }
    }
    public static void main(String[] args) {
        printBoolArray(createBoolArray(10));
    }
}
