/**
 * Created by sennhviwang
 * Time: 4:20 PM on 6/3/15
 * Not trying to handle Exceptions.
 * Variance for accumulator.
 */
public class Ex18 {
    private double m;
    private double s;
    private int N;
    public void addDataValue(double x) {
        N++;
        s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
        m = m + (x - m) / N;
    }

    public double mean() {
        return m;
    }

    public double var() {
        return s / (N - 1);
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public static void main(String[] args) {
        Ex18 example18 = new Ex18();
        for (int i = 0; i < 10; i++) {
            example18.addDataValue(Math.random()*100);
        }
        StdOut.println(example18.var());
        StdOut.println(example18.stddev());
    }
}
