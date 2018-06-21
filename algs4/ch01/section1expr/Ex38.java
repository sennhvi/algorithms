import java.util.Arrays;

/**
 * Created by sennhviwang
 * Time: 11:33 PM on 5/23/15
 * Not trying to handle Exceptions.
 * Binary search versus brute-force search.
 * Write a program BruteForceSearch that uses the brute-force search method given
 * on page 48 and compare its running time on your computer with that
 * of BinarySearch for largeW.txt and largeT.txt .
 */
public class Ex38 {

    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int binaryRank(int key, int[] a) {
        int lo = 0;
        int hi = a.length -1;
        while (lo <= hi) {
            // Key is in a[lo...hi] or not present.
            int mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else  if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * brute-force search, just find key one by one.
     * @param key number to be found.
     * @param a the array of integers, must be sorted in ascending order.
     * @return index of key in array a[] if present; -1 if not present.
     */
    public static int bruteRank(int key, int[] a) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == key) return i;
        return -1;
    }
    public static void main(String[] args) {
        // Read integer from a file.
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        in.close();

        // Sort the array.
        Arrays.sort(whitelist);

        long startTime = System.currentTimeMillis();
        // Read integer from standard input; print if not in whitelist.
        // Binary Search takes time: 1900 ms.
        // Note: You need to comment code below for precisely handling data.
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (binaryRank(key, whitelist) != -1)
                continue;
        }

        long endTime = System.currentTimeMillis();
        long binaryTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (bruteRank(key, whitelist) != -1)
                continue;
        }
        endTime = System.currentTimeMillis();
        StdOut.println("Binary Search takes time:" + binaryTime);
        // Brute-force Search takes time:327080 ms.

        StdOut.println("Brute-force Search takes time:" + (endTime-startTime));

    }
}
