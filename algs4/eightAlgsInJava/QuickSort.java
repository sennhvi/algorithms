/**
 * Created by sennhviwang
 * Time: Fri Jun 12 01:12:19 CST 2015.
 *
 * Quick Sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(nlogn)(simple partition) or O(n) (three-way partition and equal keys)
 * Time Complexity-Average: O(nlogn)
 * Time Complexity-Worst:   O(n2)
 * Space Complexity-Worst:  O(logn) auxiliary
 *
 * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm,
 * serving as a systematic method for placing the elements of an array in order.
 * When implemented well, it can be about two or three times faster than its main competitors, merge sort and heapsort.
 *
 * Quicksort is a comparison(divide and conquer algorithm) sort,
 * meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.
 * In efficient implementations it is not a stable sort, meaning that the relative order of equal sort items is not preserved.
 * Quicksort can operate in-place on an array, requiring small additional amounts of memory to perform the sorting.
 * cite: wikipedia
 */

public class QuickSort{
    private int[] a;
    public QuickSort(){
    }
    public void quickSort(int[] a) {
        if ( a.length > 0 )    // Check if the array is empty
            _quickSort(a, 0, a.length -1 );
    }

    private void _quickSort(int[] list, int lo, int hi) {
        if ( lo < hi ) {
            // divide array in two parts
            int mid = getMid(list, lo, hi);
            // apply quick sort to the lower list and upper list separately
            _quickSort(list, lo, mid - 1);
            _quickSort(list, mid + 1, hi);
        }
    }

    private int getMid(int[] list, int lo, int hi) {
        // set the first element as pivot
        int tmp = list[lo];
        while ( lo < hi ) {
            while ( lo < hi && list[hi] >= tmp )
                hi--;
            // move number lower than pivot to the lower part
            list[lo] = list[hi];
            while ( lo < hi && list[lo] <= tmp )
                lo++;
            // move number bigger than pivot to the upper part
            list[hi] = list[lo];
        }
        // add pivot to the trailing of lower part
        list[lo] = tmp;
        // return position of pivot
        return lo;

    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,23576,6723,478,878};
        QuickSort test = new QuickSort();
        test.quickSort(a);
        test.printArray(a);
    }

}
