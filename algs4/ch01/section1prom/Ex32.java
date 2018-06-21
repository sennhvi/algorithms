/**
 * Created by sennhviwang
 * Time: 1:47 AM on 5/19/15
 * Not trying to handle Exceptions.
 * Histogram.
 * Suppose that the standard input stream is a sequence of double values.
 * Write a program that takes an integer N and two double values l and r from the
 * command line and uses StdDraw to plot a histogram of the count of the numbers in the
 * standard input stream that fall in each of the N intervals defined by dividing (l , r) into
 * N equal-sized intervals.
 * Usage:
 *  -generate random double file: python generate_random_double_file.py
 *  -specify the number of lines in file: 10000
 *  -draw histogram: java Ex32 50 20.0 80.0 (after compiling)
 */
public class Ex32 {
    /**
     * draw Histogram
     * @param N number of intervals
     * @param l lower bound
     * @param r upper bound
     * @param cnt data counter for double array as standard input stream.
     */
    public static void drawHistogram(int N, double l, double r, int[] cnt) {
        double x = 0.0;
        double y = 0.0;
        double rh = 0.0;
        double rw = (r-l) / N / 2.0;

        StdDraw.setXscale(l, r);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        // Find the large most number to decide the top of histogram.
        double max = cnt[0];
        for(int i = 1; i < cnt.length; ++i) {
            if(max < cnt[i])
                max = cnt[i];
        }
        // Draw filled Rectangle.
        for (int i = 0; i < cnt.length; i++) {
            x = (r - l) * i / N + l + rw;
            y = cnt[i] / 2.0 / (max+1);
            rh = y;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    /**
     * count numbers in specified intervals and return a counter array.
     * @param N number of intervals.
     * @param l the lower bound.
     * @param r the upper bound.
     * @param testStream the standard input stream.
     * @return return a counter array.
     */
    public static int[] counter(int N, double l, double r, double[] testStream) {
        int[] cnt = new int[N];
        int idx = 0;
        double remain = 0.0;
        double gap = (r - l) / N;
        // Subtract each element in testStream by the lower bound and use the remain to decide
        // where corresponding number locates in.
        for(int i = 0; i < testStream.length; ++i) {
            remain = testStream[i] - l;
            idx = (int)(remain / gap);
            // Note: Index out of array
            if (remain < 0 || idx >= N)
                continue;
            else
            cnt[idx]++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double l = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        // You can use "< testDoubleFile.txt" at cli as standard input stream.
        In in = new In("testDoubleFile.txt");
        double[] testStream = in.readAllDoubles();

        int[] cnt = counter(N, l, r, testStream);
        drawHistogram(N, l, r, cnt);
    }
}
