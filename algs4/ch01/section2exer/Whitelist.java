/**
 * Created by sennhviwang
 * Time: 3:01 PM on 5/28/15
 * Not trying to handle Exceptions.
 */
public class Whitelist {
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] w = in.readAllInts();

        StaticSETofInts set = new StaticSETofInts(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}
