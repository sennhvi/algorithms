import java.util.Arrays;

/**
 * Created by sennhviwang
 * Time: 2:56 PM on 5/28/15
 * Not trying to handle Exceptions.
 */
public class StaticSETofInts {
    private int[] a;
    public StaticSETofInts(int[] keys) {
        a = new int[keys.length];
        for (int i = 0; i < keys.length; i++)
            // protected copy.
            a[i] = keys[i];
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        // binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // key is in a[lo ... hi],or not.
            int mid = lo + (hi-lo) / 2;
            if (key <a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return  -1;
    }
}
