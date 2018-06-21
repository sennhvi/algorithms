import java.util.Arrays;

/**
 * Created by sennhviwang
 * Time: 4:07 PM on 5/24/15
 * Not trying to handle Exceptions.
 * Random matches.
 * Write a BinarySearch client that takes an int value T as command-line argument
 * and runs T trials of the following experiment for N = 10 3 , 10 4 , 10 5 , and 10 6 :
 * generate two arrays of N randomly generated positive six-digit int values,
 * and find the number of values that appear in both arrays.
 * Print a table giving the average value of this quantity over the T trials for each value of N.
 */
public class Ex39 {
    /**
     * Searches for the integer key in the sorted array a[].
     * @param key the search key
     * @param a the array of integers, must be sorted in ascending order
     * @return index of key in array a[] if present; -1 if not present
     */
    public static int binarySearch(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo...hi] or not present.
            int mid = (lo + hi) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * Generate array by inputting power of the array with base equals to 10.
     * @param power magnitude of array size.
     * @return generated array contains elements of 10 to the power.
     */
    public static int[] generateArray(int power) {
        int arraySize = (int) Math.pow(10, power);
        int paddingNum = (int)Math.pow(10,5);
        int ceilingNum = (int)Math.pow(10,6);
        int[] generatedArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            generatedArray[i] = StdRandom.uniform(paddingNum, ceilingNum);
        }
        return generatedArray;
    }

    /**
     * Count matched number in both arrays with generation called in this method.
     * @param power magnitude of array size.
     * @return number of elements in both arrays.
     */
    public static int countNum(int power) {
        int[] arrayA = generateArray(power);
        int[] arrayB = generateArray(power);
        int cnt = 0;
        Arrays.sort(arrayB);
        for (int i = 0; i < arrayA.length; i++) {
            if (binarySearch(arrayA[i], arrayB) != -1)
                cnt++;
        }
        return cnt;
    }

    /**
     * Get input as T, repeat countNum method for T times,i.e. for each time,generate two new arrays and
     * count numbers in both array.
     * @param T times of repetition.
     * @param power magnitude of array size.
     * @return a integer of average number in repeating count number method for T times.
     */
    public static int calculateAverage(int T, int power) {
        int timesAverage = 0;
        int sum = 0;
        for (int i = 0; i < T; i++) {
            sum += countNum(power);
        }
        timesAverage = sum / T;
        return timesAverage;
    }

    /**
     * Print result table, array as input.
     * @param a input array.
     */
    public static void printTable(int[] a) {
        for (int i = 3; i < 7; i++) {
            StdOut.printf("%-10d", i);
        }
        StdOut.println();
        for (int i = 0; i < 4; i++) {
            StdOut.printf("%-10d", a[i]);
        }
    }
    public static void main(String[] args) {
        // read the integers from a file
        In in = new In();
        int T = in.readInt();

        int[] table = new int[4];
        for (int i = 0; i < 4; i++) {
            table[i] = calculateAverage(T, (i+3));
        }
        printTable(table);
    }
}
