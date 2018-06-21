import java.util.Arrays;
/**
 * Created by sennhviwang
 * Time: 3:26 PM on 5/15/15
 * Not trying to handle Exceptions.
 */
public class Ex29 {
    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return number of numbers lower than key.
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                while (mid > 0 && a[mid] == a[mid-1])
                    mid--;
                return mid;
            }
        }
        // lo is the value of numbers that are less than key.
        return lo;
    }

    /**
     * count numbers equal to key.
     * @param key number to be searched.
     * @param a the array to be searched.
     * @return return times of key in array.
     */
    public static int count(int key, int[] a) {
        int cntIndex = rank(key, a);
        if (cntIndex == a.length || key != a[cntIndex])
            return 0;
        int cnt = 1;
        // Note: order of decisions.
        while ((cntIndex < a.length - 1) && a[cntIndex] == a[cntIndex + 1]) {
            cnt++;
            cntIndex++;
        }
        return cnt;
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument. Reads in integers from standard input and
     * prints to standard output those integers that do *not* appear in the file.
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int lowers = rank(key, whitelist);
            int equals = count(key, whitelist);

            StdOut.println("The number of numbers lower than "+ key + " is " + lowers);
            StdOut.println("The number of numbers equal to  "+ key + " is " + equals);
        }
    }
}
