/**
 * Created by sennhviwang
 * Time: 10:59 AM on 5/30/15
 * Not trying to handle Exceptions.
 * Write an Interval2D client that takes command-line arguments N , min , and max
 * and generates N random 2D intervals whose width and height are uniformly distributed
 * between min and max in the unit square.
 * Draw them on StdDraw and print the number of pairs of intervals that intersect
 * and the number of intervals that are contained in one another.
 *
 * Usage: java Ex03 10 0.1 0.9
 */
public class Ex03 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]) ;
        double max = Double.parseDouble(args[2]) ;
        // initialize canvas size and pen color in gray.
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(StdDraw.GRAY);

        // create array with size of N separately for Interval1D ,2D, Point2D.
        Interval2D[] boxs = new Interval2D[N];
        Interval1D[] xIntervals = new Interval1D[N];
        Interval1D[] yIntervals = new Interval1D[N];
        double average = (max - min);
        // points is for determining inclusive relationship.
        Point2D[][] points = new Point2D[N][2];

        // generate 2 intervals' values, record two points on the cross, draw all boxs.
        for (int i = 0; i < N; i++) {
            double xlo = Math.random();
            double ylo = Math.random();
            double xhi = xlo + average * Math.random();
            double yhi = ylo + average * Math.random();
            if (xhi > 1) xhi = 1;
            if (yhi > 1) yhi = 1;

            points[i][0] = new Point2D(xlo, ylo);
            points[i][1] = new Point2D(xlo, xhi);

            xIntervals[i] = new Interval1D(xlo, xhi);
            yIntervals[i] = new Interval1D(ylo, yhi);
            boxs[i] = new Interval2D(xIntervals[i], yIntervals[i]);
            boxs[i].draw();
        }

        // draw intersected box pair in red color.
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (boxs[i].intersects(boxs[j])){
                    StdDraw.setPenColor(StdDraw.BOOK_RED);
                    boxs[i].draw();
                    boxs[j].draw();
                }
            }
        }

        // draw contained box in green and container in blue, print results.
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (boxs[i].contains(points[j][0]) && boxs[i].contains(points[j][1])) {
                    StdDraw.setPenRadius(.005);
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                    boxs[i].draw();
                    StdDraw.setPenColor(StdDraw.GREEN);
                    boxs[j].draw();
                    StdOut.println("i=" + i + "j=" + j + " " + boxs[i].toString() + boxs[j].toString());
                }
            }
            
        }
    }
}
