/**
 * Created by sennhviwang
 * Time: Fri Jun 12 16:23:38 CST 2015.
 *
 * Merge sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(nlogn) typical, O(n) natural variant
 * Time Complexity-Average: O(nlogn)
 * Time Complexity-Worst:   O(nlogn)
 * Space Complexity-Worst:  O(n) auxiliary
 *
 * Merge sort is an O(nlogn) comparison-based sorting algorithm.Most implementations produce a stable sort,
 * which means that the implementation preserves the input order of equal elements in the sorted output.
 *
 * Mergesort is a divide and conquer algorithm which has top-down implementation and bottom-up implementation:
 * It divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).
 * Then repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining.
 * This will be the sorted list.
 * cite: wikipedia
 */

public class MergeSort {
    private int[] a;
    public MergeSort() {
    }

    // Entrance of method. Initialize method
    public void mergeSort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        mergeDo(a, left, right);
    }

    private void mergeDo(int[] a, int left, int right) {
        if ( left < right ) {
            // Locate the center index
            int center = (left + right) / 2;
            // Do mergesort to the left part of array
            mergeDo(a, left, center);
            // Do mergesort to the right part of array
            mergeDo(a, center + 1, right);
            // merge array
            mergeArray(a, left, center, right);
        }
    }

    private void mergeArray(int[] a, int left, int center, int right) {
        int[] tmpArray = new int[a.length];
        int mid = center + 1;
        // Record the index of temp array
        int third = left;
        int tmp = left;
        while ( left <= center && mid <= right ) {
            // Pick the minimum element to the temp array
            if (a[left] <= a[mid])
                tmpArray[third++] = a[left++];
            else
                tmpArray[third++] = a[mid++];
        }
        // Put the rest part to temp array
        while ( mid <= right ) {
            tmpArray[third++] = a[mid++];
        }
        while ( left <= center ) {
            tmpArray[third++] = a[left++];
        }
        // Copy temp array to origin array
        while ( tmp < right ) {
            a[tmp] = tmpArray[tmp++];
        }
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,23576,6723,478,878};
        MergeSort test = new MergeSort();
        test.mergeSort(a);
        test.printArray(a);
    }
}
