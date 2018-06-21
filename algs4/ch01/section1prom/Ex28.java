import java.util.Arrays;
/**
 * Created by sennhviwang
 * Time: 11:53 PM on 5/12/15
 * Not trying to handle Exceptions.
 */
public class Ex28 {
    /**
     * count repeat elements in array.
     * @param a array as input.
     * @return times of all repeat elements
     */
    public static int countRepeatElementsInArray(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length-1; i++) {
            // Note: off by one error
            if ( a[i] == a[i+1])
                cnt++;
        }
        return cnt;
    }

    /**
     * delete repeat elements in array,return no-repeated array.
     * @param a array as input.
     * @param cnt number of repeat elements in array.
     * @return no-repeated array.
     */
    public static int[] deleteRepeatElementsInArray( int[] a, int cnt) {
        int[] result = new int[a.length - cnt];
        int cntIndex = 0;
        // cntIndex++ == 0,after ++ operation its value is 1
        result[cntIndex++] = a[0];
        for (int i = 1; i < a.length; i++) {
            // Note: off by one error
            if (a[i] == a[i-1])
                continue;
            else
            // Assign value to array result and do increment.
                result[cntIndex++] = a[i];
        }
        return result;
    }
    public static void main(String[] args) {
        // Read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        in.close();

        Arrays.sort(whitelist);
        // Print origin array
        for (int i = 0; i < whitelist.length; i++)
            StdOut.print(whitelist[i] + "\t");
        StdOut.println();

        // Count repeat elements in array and generate result array.

        int cnt = countRepeatElementsInArray(whitelist);
        int resultArray[] = deleteRepeatElementsInArray(whitelist, cnt);

        // Print result array.
        for (int i = 0; i < resultArray.length; i++)
            StdOut.print(resultArray[i] + "\t");
        StdOut.println();

    }
}
