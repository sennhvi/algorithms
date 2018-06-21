/**
 * Created by sennhviwang
 * Time: 4:56 AM on 5/18/15
 * Not trying to handle Exceptions.
 * Write a program that takes as command-line arguments
 * an integer N and a double value p (between 0 and 1), plots N equally spaced dots of size .05
 * on the circumference of a circle, and then, with probability p for each pair of points,
 * draws a gray line connecting them.
 */
public class Ex31 {
    /**
     * Draw a circle as initialization, set its scale double the x and y.
     * @param x parameter of x coordinate.
     * @param y parameter of y coordinate.
     * @param r radius of circle
     */
    public static void drawCircle(double x, double y, double r) {
        StdDraw.setXscale(0, 2 * x);
        StdDraw.setYscale(0, 2 * y);
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.circle(x, y, r);
    }

    /**
     * draw N points,divide circle into N parts and use cos and sin to locate them.
     * @param x0 x coordinate of center of circle.
     * @param y0 y coordinate of center of circle.
     * @param r radius of circle.
     * @param N number of points.
     * @return return points array.
     */
    public static double[][] drawPoints(double x0, double y0, double r, int N) {
        double[][] points = new double[N][2];
        StdDraw.setPenRadius(.005);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        for (int i = 0; i < N; i++) {
            double x = x0 + r * Math.cos(2 * Math.PI * i / N);
            double y = y0 + r * Math.sin(2 * Math.PI * i / N);
            StdDraw.point(x, y);
            points[i][0] = x;
            points[i][1] = y;
        }
        return points;
    }

    /**
     * connect random points using bernoulli distribution.
     * @param points x and y coordinates of points array.
     * @param p probability.
     */
    public static void randomConnectPoints(double[][] points, double p) {
        StdDraw.setPenRadius(.002);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        int length = points.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (StdRandom.bernoulli(p) == true)
                    StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
            }
        }
    }
    public static void main(String[] args) {
        double x = 10.0;
        double y = 10.0;
        double radius = 8.0;
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        drawCircle(x, y, radius);
        randomConnectPoints(drawPoints(x, y, radius, N),p);
    }
}
