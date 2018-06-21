/*************************************************************************
 *  Compilation:  javac Accumulator.java
 *  Execution:    java Accumulator
 *
 *  Mutable data type that calculates the mean, sample standard
 *  deviation, and sample variance of a stream of real numbers
 *  use a stable, one-pass algorithm.
 *
 *  This one-pass implementation is less susceptible to roundoff
 *  error than the straightforward implementation based on saving
 *  the sum of the squares of the numbers.
 *
 *
 *  Here is a good explanation of the one-pass method, that was
 *  first discovered by Welford in 1962.
 *
 *  http://www.johndcook.com/blog/standard_deviation/
 *
 *  This approach can also be applied to computing
 *  the skewness, kurtosis, regression coefficients, and Pearson's
 *  correlation coefficient.
 *
 *  http://www.johndcook.com/blog/skewness_kurtosis/
 *
 *
 *************************************************************************/


public class Accumulator {
    private int N = 0;
    private double sum = 0.0;
    private double mu = 0.0;

    // add data value x
    public void addDataValue(double x) {
        N++;
        sum += 1.0 * (N - 1) / N * (x - mu) * (x - mu);
        mu += (x - mu) / N;
    }

    // mean
    public double mean() {
        return mu;
    }

    // sample variance
    public double var() {
        return sum / (N - 1);
    }

    // sample standard deviation
    public double stddev() {
        return Math.sqrt(this.var());
    }

    // number of data values
    public int count() {
        return N;
    }


    public static void main(String[] args) {
        Accumulator stats = new Accumulator();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
        }

        StdOut.printf("N      = %d\n",   stats.count());
        StdOut.printf("mean   = %.5f\n", stats.mean());
        StdOut.printf("stddev = %.5f\n", stats.stddev());
        StdOut.printf("var    = %.5f\n", stats.var());
    }
}
