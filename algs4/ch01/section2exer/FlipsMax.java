/**
 * Created by sennhviwang
 * Time: 12:18 AM on 5/28/15
 * Not trying to handle Exceptions.
 * Objects as return value and args.
 */
public class FlipsMax {
    // Objects as return value, return the bigger one.
    public static Counter max(Counter x, Counter y) {
        if (x.tally() > y.tally()) return x;
        else                       return y;
    }

    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int t = 0; t < T; t++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        if (heads.tally() == tails.tally())
            StdOut.println("Tie");
        else StdOut.println(max(heads, tails) + "wins");

    }
}
