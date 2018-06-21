/**
 * Created by sennhviwang
 * Time: 10:28 PM on 5/31/15
 * Not trying to handle Exceptions.
 * Develop a class VisualCounter that allows both increment and decrement operations.
 * Take two arguments N and max in the constructor, where N specifies the maximum number
 * of operations and max specifies the maximum absolute value for the counter.
 * As a side effect, create a plot showing the value of the counter each time its tally changes.
 */
public class VisualCounter {
    private int count;
    private int val;
    private int x;
    int maxOperation;
    int maxVal;

    public VisualCounter(int N, int max){
        maxOperation = N;
        maxVal = max;
        StdDraw.setXscale(0, N+1);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(.005);
    }

    public int tally() {
        return count;
    }

    public void increment() {
        if (count < maxOperation && val < maxVal) {
            count++;
            val++;
            x++;
            StdDraw.text(x, val, String.valueOf(val));
        }
    }

    public void decrement() {
        if (count < maxOperation && val > -maxVal) {
            count++;
            val--;
            x++;
            StdDraw.text(x, val, String.valueOf(val));
        }
    }

    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(10, 20);

        vc.increment();
        vc.increment();
        vc.decrement();
        vc.decrement();
        vc.decrement();

        StdOut.print(vc.tally());
    }
}
