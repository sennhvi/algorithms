/**
 * Created by sennhviwang
 * Time: 9:58 PM on 5/27/15
 * Not trying to handle Exceptions.
 * The class Flips is a Counter client that takes a command-line argument T and
 * simulates T coin flips (it is also a StdRandom client).
 * Using objects.
 */
public class Flips {
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0; t < T; t++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));
    }
}
