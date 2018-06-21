/**
 * Created by sennhviwang
 * Time: 8:28 AM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex9 {
    /**
     * main function.
     * Display a positive integer N in binary format and
     * convert it to a String type variable s.
     * @param args
     */
    public static void main(String[] args) {
        StdOut.println("please input a positive integer");
        int N = StdIn.readInt();
        String s = "";
        for (int n = N; n > 0; n/=2)
            s = (n % 2) + s;
        StdOut.printf("%s", s);
    }
}
