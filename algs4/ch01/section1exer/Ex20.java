/**
 * Created by sennhviwang
 * Time: 1:02 AM on 5/9/15
 * Not trying to handle Exceptions.
 */
public class Ex20 {
    /**
     * calculate ln(N!) using recursive function.
     * @param N input value
     * @return recursive function.
     */
    public static double factorialLn( long N) {
        if ( N > 1)
            return factorialLn(N-1) + Math.log(N);
        else
            return 0;
    }

    /**
     * test function
     * @param args do nothing
     */
    public static void main(String[] args) {
        StdOut.print(factorialLn(100));
    }
}
