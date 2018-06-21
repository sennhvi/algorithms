/**
 * Created by sennhviwang
 * Time: Tue Jun 9 23:35:41 CST 2015.
 *
 * Insertion sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(n)
 * Time Complexity-Average: O(n2)
 * Time Complexity-Worst:   O(n2)
 * Space Complexity-Worst:  O(n) total, O(1) auxiliary
 *
 * Unlike many sorting algorithms with quadratic complexity,
 * it is actually applied in practice for sorting small arrays of data.
 *
 * Insertion sort iterates,consuming one input element each repetition,
 * and growing a sorted output list.
 * Each iteration,insertion sort removes one element from the input data,
 * finds the location it belongs within the sorted list,and inserts it there.
 * It repeats until no input elements remain.
 * cite:wikipedia
 */

public class InsertionSort {
    private int[] a;
    public InsertionSort() {
    }
    public void insertionSort(int[] arr){
        // from 2nd element, do sth. to grow output list:)
        for (int i = 1; i < arr.length; i++) {
            // compare each new element's value with output list
            int newValue = arr[i];
            // j stores how many numbers remain to be compared in output list right now
            int j = i;
            // if j > 0 (still has number to compare),and arr[j-1] > newValue,i.e.
            // (the new element is less than the last element of output list,
            // then we need to move the bigger element to the later element's position recursively
            // until there has no elements to compare or the new element is not less than the [j-1] element.
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j-1];
                j--;
            }
            // and we will assign the new element to position of j.
            arr[j] = newValue;
        }
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,23576,6723,478,878};
        InsertionSort test = new InsertionSort();
        test.insertionSort(a);
        test.printArray(a);
    }
}
