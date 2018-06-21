/**
 * Created by sennhviwang
 * Time: 12:02 PM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex14 {
    /**
     * function lg() returns the biggest integer which is less than or equal to log2N
     * you can extend this function by replacing 2 with other integer below
     * @param N value of input integer
     * @return a
     */
    public static int lg(int N) {
        int a = 0;
        while (2 <= N) {
            N /= 2;
            a++;
        }
        return a;
    }
    public static void main(String[] args) {
        StdOut.println("Input integer number N");
        int N = StdIn.readInt();
        StdOut.println("Return value is: " + lg(N));
    }
}
