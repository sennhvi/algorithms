import java.awt.*;

/**
 * Created by sennhviwang
 * Time: 11:20 AM on 5/29/15
 * Not trying to handle Exceptions.
 * Write an Interval1D client that takes an int value N as command-line argument,
 * reads N intervals (each defined by a pair of double values) from standard input,
 * and prints all pairs that intersect.
 */
public class Ex02 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        Interval1D[] interval = new Interval1D[N];
        double[] d = new double[2 * N];
        StdOut.println("left <= right");
        // Get inputs.
        for (int i = 0; i < 2 * N; i++) {
            if (i % 2 == 0) {
                StdOut.print("Interval [" + (i / 2) + "]--left:");
                d[i] = StdIn.readDouble();
            }
            else {
                StdOut.print("Interval [" + (i / 2) + "]--right:");
                d[i] = StdIn.readDouble();
            }
        }

        // Draw each line in different color.
        for (int i = 0; i < N; i++) {
            interval[i] = new Interval1D(d[2*i], d[2*i + 1]);
            StdDraw.setPenRadius(0.008);
            StdDraw.setPenColor(new java.awt.Color((int)(1000* Math.random() % 255),(int)(10000* Math.random() % 255),(int)(100000* Math.random() % 255)));
            StdDraw.line(interval[i].left(), i * 0.1 % 1, interval[i].right(), i*0.1 % 1);
        }

        // Draw intersecting line.
        for (int i = 0; i < N / 2; i++) {
            for (int j = N/2; j < N; j++) {
                if (i != j)
                    if (interval[i].intersects(interval[j])) {
                        StdDraw.setPenRadius(0.004);
                        StdDraw.setPenColor(Color.RED);
                        StdDraw.line(interval[i].left(), .5, interval[j].right(), .5);
                        StdOut.println("Interval [" + i + "] intersections with interval [" + j + "].");
                    }
            }
        }
    }
}
