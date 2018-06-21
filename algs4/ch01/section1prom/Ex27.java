/**
 * Created by sennhviwang
 * Time: 4:43 PM on 5/10/15
 * Not trying to handle Exceptions.
 */
public class Ex27 {
    public static int cnt = 0;

    /**
     * calculate binomial method in recursive way ( n choose k).
     * @param N can be seen as the set
     * @param k can be seen as the chosen number
     * @param p coefficient of binomial method
     * @return recursive call
     */
    public static double binomial(int N, int k, double p) {
        cnt++;
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N-1, k, p) + p * binomial(N-1, k-1, p);
    }

    /**
     * calculate element in binomialArray method by using Array to store inferior element
     * @param N the set
     * @param k the chosen number
     * @param p coefficient of binomial method
     * @return the latest number,i.e.,(N,k)
     */
    public static double binomialArray( int N, int k, double p) {
        double[][] a = new double[N+1][k+1];
        a[0][0] = 1;
        /**
         * initialize the elements which their k = 0 in Array a,i.e.,a[i][0]
         * to calculate superior array element.
         */
        for (int i = 1; i < N + 1; i++) {
            a[i][0] = a[i-1][0] * (1 - p);
        }
        // generate each element in array
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j <= i && j < k + 1; j++) {
                a[i][j] = ( 1 - p) * a[i-1][j] + p * a[i-1][j-1];
            }
        }
        return a[N][k];
    }
    // test function
    public static void main(String[] args) {
        // test output,note: method binomial has a big time complexity.
        StdOut.println(binomial(10, 5, 0.5) + " " + cnt);
        StdOut.println(binomialArray(10, 5, 0.5));
    }
}
