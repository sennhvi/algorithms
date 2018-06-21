/**
 * Created by sennhviwang
 * Time: 17:42 PM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex18 {
    /**
     * function mystery will return a*b in origin.
     * replace "+" with "*",replace "return 0" with "return 1",will yield a^b
     * @param a base
     * @param b multiplier or exponent.
     * @return recursive function.
     */
    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0)  return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    public static void main(String[] args) {
        StdOut.println(mystery(3,2));
        StdOut.print(mystery(3,11));
    }
}
