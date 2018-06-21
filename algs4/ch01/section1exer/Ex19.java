/**
 * Created by sennhviwang
 * Time: 18:32 PM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex19 {
    /**
     * origin implement of fibonacci
     * @param N factor
     * @return recursive return
     */
    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N-1) + F(N-2);
    }
    /**
     * a better implement on F(N),using array to store calculated value.
     * @param a long type array a
     * @return array a
     */
    public static long[] A(long[] a) {
        a[0]= 0;
        a[1]= 1;
        for (int N = 2; N < 100; N++) {
            a[N] = a[N-1]+a[N-2];
            StdOut.println(N+" "+ a[N]);
        }
        return a;
    }
    public static void main(String[] args) {
        long[] a = new long[100];
        a = A(a);
    }
}
