/**
 * Created by sennhviwang
 * Time: Wed Jun 10 14:21:15 CST 2015.
 *
 * Selection sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(n2)
 * Time Complexity-Average: O(n2)
 * Time Complexity-Worst:   O(n2)
 * Space Complexity-Worst:  O(n) total, O(1) auxiliary
 *
 * Selection sort is inefficient on large lists, and generally performs worse than the similar insertion sort.
 * Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms
 * in certain situations, particularly where auxiliary memory is limited.
 * The algorithm divides the input list into two parts:
 * the sublist of items already sorted, which is built up from left to right at the front (left) of the list,
 * and the sublist of items remaining to be sorted that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
 * The algorithm proceeds by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist,
 * exchanging it with the leftmost unsorted element (putting it in sorted order),
 * and moving the sublist boundaries one element to the right.
 * cite: wikipedia
 */
public class SelectionSort {
    private int[] a;
    public SelectionSort() {
    }
   public void selectionSort(int[] arr){
        int iMin;
        int n = arr.length;
        /* arr[0] to arr[n-1] is the array to sort */
        /* advance the position through the entire array */
        /*   (could do j < n-1 because single element is also min element) */
        for (int j = 0; j < n-1; j++) {
            /* find the min element in the unsorted arr[j .. n-1] */
            /* assume the min is the first element */
            iMin = j;
            /* test against elements after j to find the smallest */
            for (int i = j+1; i < n; i++) {
                /* if this element is less, then it is the new minimum */
                if (arr[i] < arr[iMin]) {
                    /* found new minimum; remember its index */
                    iMin = i;
                }
            }
            if(iMin != j) {
                /* swap two elements in array
                 * Note: java cannot pass references of primitive types*/
                int tmp;
                tmp = arr[j];
                arr[j] = arr[iMin];
                arr[iMin] = tmp;
            }
        }
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,236,6723,478,878};
        SelectionSort test = new SelectionSort();
        test.selectionSort(a);
        test.printArray(a);
    }
}
