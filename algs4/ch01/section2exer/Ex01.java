/**
 * Created by sennhviwang
 * Time: 3:12 PM on 5/27/15
 * Not trying to handle Exceptions.
 * Write a Point2D client that takes an integer value N from the command line,
 * generates N random points in the unit square,
 * and computes the distance separating the closest pair of points.
 */
public class Ex01 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] p = new Point2D[N];
        double min = 1.00;
        // Generation of N points
        for (int i = 0; i < N; i++) {
            double x = Math.random();
            double y = Math.random();
            p[i] = new Point2D(x, y);
            p[i].draw();
        }
        // Calculation of minimum distance between two points
        int p1 = 0;
        int p2 = 0;
        for (int i =0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    if (p[i].distanceTo(p[j]) < min ){
                        min = p[i].distanceTo(p[j]);
                        p1 = i;
                        p2 = j;
                    }
                }
            }
        }
        // Draw the closest pair of points.
        Point2D point1 = p[p1];
        Point2D point2 = p[p2];
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.RED);
        point1.drawTo(point2);

        StdOut.println("The minimum distance is " + min);
    }
}
