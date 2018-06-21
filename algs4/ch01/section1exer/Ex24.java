/**
 * Created by sennhviwang
 * Time: 10:06 PM on 5/9/15
 * Not trying to handle Exceptions.
 */
public class Ex24 {
    /**
     *  Euclid algorithm,get greatest common divisor(gcd) from input(don't forget press Enter~)
     * @param a one integer
     * @param b one integer
     * @return gcd
     */
    public static int gcdEuclid(int a, int b) {
        StdOut.println("a:" + a + " b:" + b);
        if (b == 0) return a;
        else return gcdEuclid(b, a % b);
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        StdOut.println("gcd is " + gcdEuclid(a[0], a[1]));
    }
}
