/**
 * Created by sennhviwang
 * Time: 10:00 AM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex11 {
    /**
     * randomInitial.initialize array a
     */
    public static boolean[][] randomInitialBooleanArray( boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(StdRandom.bernoulli(0.1))
                    a[i][j] = true;
                else
                    a[i][j] = false;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        boolean[][] a = new boolean[10][10];
        /**
         * Output
         */
        a = randomInitialBooleanArray(a);
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0)
                    StdOut.print("|" + j);
                else {
                    if (j == 0)
                        StdOut.print("|" + i);
                    else {
                        if (!a[i - 1][j - 1])
                            StdOut.print("|*");
                        else
                            StdOut.print("| ");
                    }
                }
            }
            StdOut.print("\n");
        }
    }
}
