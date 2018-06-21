/**
 * Created by sennhviwang
 * Time: Fri Jun 12 17:13:59 CST 2015.
 *
 * Radix Sort
 * Data Structure:          Array
 * Time Complexity-Worst:   O(w)
 * Space Complexity-Worst:  O(w + N)
 *
 * Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys
 * by grouping keys by the individual digits which share the same significant position and value.
 * A positional notation is required, but because integers can represent strings of characters (e.g., names or dates)
 * and specially formatted floating point numbers, radix sort is not limited to integers.
 *
 * Two classifications of radix sorts are least significant digit (LSD) radix sorts and most significant digit (MSD) radix sorts.
 * LSD radix sorts process the integer representations starting from the least digit and move towards the most significant digit.
 * MSD radix sorts work the other way around.
 *
 * LSD radix sorts typically use the following sorting order:
 * short keys come before longer keys, and keys of the same length are sorted lexicographically.
 * This coincides with the normal order of integer representations, such as the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
 *
 * MSD radix sorts use lexicographic order, which is suitable for sorting strings, such as words, or fixed-length integer representations.
 * If lexicographic ordering is used to sort variable-length integer representations,
 * then the representations of the numbers from 1 to 10 would be output as 1, 10, 2, 3, 4, 5, 6, 7, 8, 9,
 * as if the shorter keys were left-justified and padded on the right with blank characters to make the shorter
 * keys as long as the longest key for the purpose of determining sorted order.
 * cite: wikipedia
 */

public class RadixSort {
    private int[] a;
    public RadixSort() {
    }

    public int[] radixSort(int[] a) {
        // Loop for every bit in the integers
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            // The array to put the partially sorted array into
            int[] tmpArray = new int[a.length];
            // The number of 0s
            int j = 0;

            // Move the 0s to the new array, and the 1s to the old one
            for (int i = 0; i < a.length; i++) {
                // If there is a 1 in the bit we are testing, the number will be negative
                boolean move = a[i] << shift >= 0;

                // If this is the last bit, negative numbers are actually lower
                if ( shift == 0 ? !move : move ) {
                    tmpArray[j] = a[i];
                    j++;
                } else {
                    // It's a 1, so stick it in the old array for now
                    a[i - j] = a[i];
                }
            }

            // Copy cover the 1s from the old array
            for (int i = j; i < tmpArray.length; i++)
                tmpArray[i] = a[i - j];

            // And now the tmp array gets switched for another round of sorting
            a = tmpArray;
        }
        return a;
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,236,6723,478,878};
        RadixSort test = new RadixSort();
        int[] as = test.radixSort(a);
        test.printArray(as);
    }

}
