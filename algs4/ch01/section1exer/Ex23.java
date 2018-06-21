/**
 * Created by sennhviwang
 * Time: 3:10 PM on 5/9/15
 * Not trying to handle Exceptions.
 */
import java.util.Arrays;
public class Ex23 {
    /**
     * implement of BinarySearch in recursive way
     * Usage: java Ex22 largeW.txt < largeT.txt
     * Warning: it takes a long time.depth: 19371776
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return recursive function
     */
    public static int rank(int key, int[] a, char c) {
        return rank(key, a, 0, a.length -1, c);
    }
    public static int rank(int key, int[] a, int lo, int hi, char c) {
        int mid = lo + (hi -lo) / 2;
        if ( c == '+') {
            // if not found (lo > hi),print it.
            if (lo > hi) return -1;
            if ( key < a[mid]) return rank(key, a, lo, mid -1, c);
            else if (key > a[mid]) return rank(key, a, mid + 1, hi, c);
            // if found (return mid),don't print it.
            else return mid;
        }
        if ( c == '-') {
            // if not found (lo > hi),don't print it.
            if (lo > hi) return 0;
            if ( key < a[mid]) return rank(key, a, lo, mid -1, c);
            else if (key > a[mid]) return rank(key, a, mid + 1, hi, c);
            // if found (return -1),print it.
            else return -1;
        }
        else return -1;
    }
    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that do *not* appear in the file.
     * the method readInts in class In has been deprecated.
     */
    public static void main(String[] args) {
        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        in.close();

        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            // Change search model by switching char between '-' and '+'.
            if (rank(key, whitelist, '-') == -1)
                StdOut.println(key);
        }
    }
}

