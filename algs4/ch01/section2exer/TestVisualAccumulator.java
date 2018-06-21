/**
 * Created by sennhviwang
 * Time: 1:54 PM on 5/28/15
 * Not trying to handle Exceptions.
 */
public class TestVisualAccumulator {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++) {
            a.addDataValue(Math.random());
        }
        StdOut.println(a);

    }
}
