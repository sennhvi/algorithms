/**
 * Created by sennhviwang
 * Time: 3:07 PM on 5/22/15
 * Not trying to handle Exceptions.
 * Empirical shuffle check.
 * ShuffleTest.
 */
public class Ex36 {

    /**
     * for each loop, you need to initialize array so it can be reshuffled.
     * @param M size of the array.
     * @return return a new array, in which its i == a[i].
     */
    public static int[] initializeArray(int M) {
        int[] a = new int[M];
        for (int i = 0; i < M; i++)
            a[i] = i;
        return a;
    }

    /**
     * shuffle a array,use code in book.
     * @param a array to be shuffled.
     * @return return a shuffled array.
     */
    public static int[] shuffle(int[] a) {
        int M = a.length;
        // Switch a[i] and any elements in a[i..N-1].
        for (int i = 0; i < M; i++) {
            int r = i + StdRandom.uniform(M-i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
        return a;
    }

    /**
     * count each elements in result array and increase corresponding element by 1.
     * @param a the shuffled array.
     * @param resultTable array counter,i.e. the M-by-M table.
     * @return resultTable for next time you handle a new shuffled array.
     */
    public static int[][] counterTable(int[] a, int[][] resultTable) {
        int M = a.length;

        /**
         * Simulate a 2D array.
         * for example:
         * i: 0 1 2 3 4 5
         * j: 3 1 5 4 0 2
         * a[i] ( shuffled array) == j.
         */
        for (int i = 0; i < M; i++) {
            int j = a[i];
            resultTable[i][j]++;
        }
        return resultTable;
    }

    /**
     * print all elements in a table.
     * @param table 2D array.
     */
    public static void printTable(int[][] table) {
        int tableLength = table.length;
        StdOut.printf("%-12s","Table");
        for (int i = 0; i < tableLength; i++) {
            StdOut.printf("%-12d", i);
        }
        StdOut.println();
        for (int i = 0; i < tableLength; i++) {
            StdOut.printf("%-12d",i);
            for (int j = 0; j < tableLength; j++) {
                StdOut.printf("%-12d", table[i][j]);
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        // Get input.
        In in = new In();
        StdOut.println("Size of array: M");
        int M = in.readInt();
        StdOut.println("Times of shuffle: N");
        int N = in.readInt();

        // Do experiment: check shuffle code works as advertised.
        int[] a = shuffle(initializeArray(M));
        StdOut.println("Check shuffle code works as advertised:");
        for (int i = 0; i < M; i++) {
            StdOut.printf("%-12d", a[i]);
        }
        StdOut.println();

        // Empirical shuffle check.
        StdOut.println("Empirical shuffle check:" + M + "*" + M);
        // Initialize result table.
        int[][] resultTable = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                resultTable[i][j] = 0;
            }
        }

        for (int j = 0; j < N; j++) {
            int[] initializedArray = initializeArray(M);
            int[] shuffledArray = shuffle(initializedArray);
            // resultTable will be used next time in the loop.So we can save it;)
            resultTable = counterTable(shuffledArray, resultTable);
        }
        // Show result.
        printTable(resultTable);
    }
}
