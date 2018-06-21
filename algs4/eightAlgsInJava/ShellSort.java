/**
 * Created by sennhviwang
 * Time: Wed Jun 10 04:06:52 CST 2015.
 *
 * Shell sort
 * Data Structure:          Array
 * Time Complexity-Best:    O(nlog2n)
 * Time Complexity-Average: depends on gap sequence
 * Time Complexity-Worst:   O(n2)
 * Space Complexity-Worst:  O(n) total, O(1) auxiliary
 *
 * Shellsort can be seen as either a generalization of sorting by exchange (bubble sort)
 * or sorting by insertion (insertion sort).
 * The method starts by sorting pairs of elements far apart from each other,
 * then progressively reducing the gap between elements to be compared.
 * Starting with far apart elements can move some out-of-place elements into position
 * faster than a simple nearest neighbor exchange.
 * cite:wikipedia
 */
public class ShellSort {
    private int[] a;
    public ShellSort() {
    }
    public void shellSort(int[] arr) {
        // starts with the largest gap and work down to a gap of 1
        int gap = arr.length / 2;
        while (gap > 0) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements arr[0..gap-1] are already in gapped order
            // keep adding one more element until the entire array is gap sorted
            for (int i = gap; i < arr.length; i++) {
                // add arr[i] to the elements that have been gap sorted
                // save arr[i] in temp and make a hole at position i for arr[i] or arr[i-k*gap]
                int j = i;
                int temp = arr[i];
                // shift earlier gap-sorted elements up until the correct location for arr[i] is found,jump-jump-jump...
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                // put temp (the original arr[i]) in its correct location],exchange or not
                arr[j] = temp;
            }
            // save your time
            if (gap == 2) {
                gap = 1;
            } else {
                // reduce gap for further calculation
                gap *= (5.0 / 11);
            }
        }
    }

    public void printArray(int[] a){
		for ( int i = 0; i < a.length; i++) {
			System.out.printf("%-5d", a[i]);
		}
    }

    public static void main (String[] args) {
		int[] a = {4,5,234,536,3421,52,67,234,65,7,2334,50,76,8,234,756,8,2348,236,6723,478,878};
        ShellSort test = new ShellSort();
        test.shellSort(a);
        test.printArray(a);
    }
}
