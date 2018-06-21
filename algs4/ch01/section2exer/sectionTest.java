/**
 * Created by sennhviwang
 * Time: 10:33 PM on 5/30/15
 * Not trying to handle Exceptions.
 */
public class sectionTest {
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
    public static void main(String[] args) {
        StdOut.println(mystery("fuckyou"));
    }
}
