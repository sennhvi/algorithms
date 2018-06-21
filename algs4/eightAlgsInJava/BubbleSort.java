/**
 * Created by sennhviwang
 * Time: Fri Jun 12 00:11:31 CST 2015.
 *
 * Bubble Sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(n)
 * Time Complexity-Average: O(n2)
 * Time Complexity-Worst:   O(n2)
 * Space Complexity-Worst:  O(1) auxiliary
 *
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through
 * the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order.
 * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.
 *
 * Although the algorithm is simple, it is too slow and impractical for most problems even when compared to insertion sort.
 * It can be practical if the input is usually in sort order but may occasionally have some out-of-order elements nearly in position.
 * cite: wikipedia
 */

public class BubbleSort {
    private int[] a;
    public BubbleSort() {
    }
    public void bubbleSort(int[] a) {
        boolean changed = false;
        do {
            changed = false;
            // compare each pair of adjacent items and swaps them if they are in wrong order
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] - a[i + 1] > 0) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    changed = true;
                }
            }
        }
        while (changed);
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,23576,6723,478,878};
        BubbleSort test = new BubbleSort();
        test.bubbleSort(a);
        test.printArray(a);
    }
}
