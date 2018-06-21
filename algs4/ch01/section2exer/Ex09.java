import java.util.Arrays;

/**
 * Created by sennhviwang
 * Time: 3:02 PM on 5/31/15
 * Not trying to handle Exceptions.
 * Instrument BinarySearch (page 47) to use a Counter to count the total number
 * of keys examined during all searches and then print the total after all searches are complete.
 * Hint : Create a Counter in main() and pass it as an argument to rank() .
 */
public class Ex09 {
    public static int rank(int key, int[] a, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        counter.increment();
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        Counter counter = new Counter("search times");

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist, counter) == -1)
                continue;
        }
        StdOut.println(counter);
    }
}
