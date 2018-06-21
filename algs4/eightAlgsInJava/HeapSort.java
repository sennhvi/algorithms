import java.util.Arrays;
/**
 * Created by sennhviwang
 * Time: Thu Jun 11 01:50:45 CST 2015.
 *
 * Heap sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(nlogn)
 * Time Complexity-Average: O(nlogn)
 * Time Complexity-Worst:   O(nlogn)
 * Space Complexity-Worst:  O(1) auxiliary
 *
 * Heapsort is a comparison-based sorting algorithm.
 * Although somewhat slower in practice on most machines than a well-implemented quicksort,
 * it has the advantage of a more favorable worst-case O(n log n) runtime.
 * Heapsort is an in-place algorithm, but it is not a stable sort.
 *
 * Heapsort can be thought of as an improved selection sort: like that algorithm,
 * it divides its input into a sorted and an unsorted region,
 * and it iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region.
 * The improvement consists of the use of a heap data structure rather than a linear-time search to find the maximum.
 * cite: wikipedia
 */

public class HeapSort{
    private int[] a;
    public HeapSort() {
    }
    public void heapSort(int[] a) {
        int count = a.length;
        // first place a in max-heap order
        heapify(a, count);

        int end = count - 1;
        while(end > 0) {
            // swap the root(maximum value) of the heap with the last element of the heap
            int tmp = a[end];
            a[end] = a[0];
            a[0] = tmp;
            // put the heap back in max-heap order
            siftDown(a, 0, end - 1);
            // decrement the size of the heap so that the previous max value will stay in its proper place
            end--;
        }
    }

    private void heapify(int[] a, int count) {
        // start is assigned the index in a of the last parent node
        int start = ( count - 2 ) / 2; // binary heap

        while( start >= 0 ) {
            // shift down the node at index start to the proper place such that all nodes below the start index are in heap order
            siftDown(a, start, count - 1);
            start--;
        }
        // after sifting down the root all nodes/elements are in heap order
    }

    private void siftDown(int[] a, int start, int end) {
        // end represents the limit of how far down the heap to sift
        int root = start;

        while( (root * 2 + 1) <= end ) { // while the root has at least one child
            int child = root * 2 + 1;   // root * 2 + 1 points to the left child
            // if the child has sibling and child's value is less than its sibling's ...
            if ( child + 1<= end && a[child] < a[child + 1])
                child++;                // then points to the right child instead
            if ( a[root] < a[child] ) { // out of the max-heap order
                int tmp = a[root];
                a[root] = a[child];
                a[child] = tmp;
                root = child;           // repeat to continue sifting down the child now
            }else return;
        }
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main(String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,23576,6723,478,878};
        HeapSort test = new HeapSort();
        test.heapSort(a);
        test.printArray(a);
    }
}
