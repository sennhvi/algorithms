import java.util.Arrays;

/**
 * Created by sennhviwang
 * Time: 1:02 PM on 5/9/15
 * Not trying to handle Exceptions.
 */
public class Ex22 {
    /**
     * implement of BinarySearch in recursive way
     * Usage: java Ex22 largeW.txt < largeT.txt
     * Warning: it takes a long time.depth: 19371776
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return recursive function
     */
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length -1);
    }
    public static int rank(int key, int[] a, int lo, int hi) {

        StdOut.println("lo:" + lo + " hi:" + hi + " tag:" + tag++);
        if (lo > hi) return -1;
        int mid = lo + (hi -lo) / 2;
        if ( key < a[mid]) return rank(key, a, lo, mid -1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }
    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that do *not* appear in the file.
     * the method readInts in class In has been deprecated.
     */
    static int tag = 0;
    public static void main(String[] args) {
        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        in.close();

        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
