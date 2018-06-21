/**
 * Created by sennhviwang
 * Time: 11:08 PM on 5/21/15
 * Not trying to handle Exceptions.
 * Dice simulation.
 * Run experiments to validate this calculation simulating N dice throws,
 * keeping track of the frequencies of occurrence of each value
 * when you compute the sum of two random integers between 1 and 6.
 * How large does N have to be before your empirical results match the exact results
 * to three decimal places?
 */
public class Ex35 {

    // Dice has 6 directions.
    public static int SIDES = 6;

    /**
     * Print array.
     * @param dist  array to be printed.
     */
    public static void print(double[] dist) {
        for(int i = 2; i <= 2 * SIDES; ++i)
            StdOut.println(dist[i]);
        StdOut.println("-------------------------");
    }

    /**
     * Calculate probability based on given distribution.
     * @param dist  statistical array.
     * @return  probability array.
     */
    public static double[] computeProbability(double[] dist, int testTimes) {
        for(int i = 2; i <= 2 * SIDES; ++i)
            dist[i] /= (1.0 * testTimes);
        return dist;
    }

    /**
     *  Calculate the theoretical probability array.
     * @return theoretical probability array.
     */
    public static double[] theoreticalValue() {
        double[] dist = new double[2 * SIDES + 1];

        for(int i = 1; i <=SIDES; ++i)
            for(int j = 1; j <= SIDES; ++j)
                dist[i+j] += 1.0;
        // calculate probability.
        dist = computeProbability(dist, 36);
        return dist;
    }

    /**
     *  Calculate the experimental probability array.
     * @param N attempts times.
     * @return  experimental probability array.
     */
    public static double[] simulate(int N) {
        double[] dist = new double[2 * SIDES + 1];
        // generate random statistics for dice.
        for(int i = 0; i < N; ++i) {
            int a = StdRandom.uniform(1, 6 + 1);
            int b = StdRandom.uniform(1, 6 + 1);
            dist[a + b] += 1.0;
        }
        // calculate probability.
        dist = computeProbability(dist, N);
        return dist;
    }

    /**
     * Decide whether condition is matched.
     * @param dist0 theoretical probability array.
     * @param dist1 experimental probability array.
     * @return  if matched, return true.
     */
    public static boolean isMatch(double[] dist0, double[] dist1) {
        for(int i = 2; i <= 2 * SIDES; ++i)
            if(Math.abs(dist0[i] - dist1[i]) >= 0.0001)
                return false;
        return true;
    }

    /**
     * Test N,the times of test making condition matched.
     * @param initTimes   initialized time of attempts.
     * @param dist0 theoretical probability array.
     * @return required N.
     */
    public static int testGetN(int initTimes, double[] dist0) {
        int N = initTimes;
        boolean match = false;
        while(!match) {
            double[] dist1 = simulate(N);
            match = isMatch(dist0, dist1);
            if(match)
                print(dist1);
            // if N is not satisfied, times if by 10.
            N *= 10;
        }
        return N;
    }

    public static void main(String[] args) {
        double[] dist0 = theoreticalValue();
        print(dist0);
        int initTimes = 1000000;
        int N = testGetN(initTimes, dist0);
        StdOut.println("Least times of attempts:" + N);
    }
}
