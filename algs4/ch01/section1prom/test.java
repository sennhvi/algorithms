/**
 * Created by sennhviwang
 * Time: 2:43 PM on 5/14/15
 * Not trying to handle Exceptions.
 */
public class test {
    public static void main(String[] args) {
        In in = new In();
        int row = in.readInt();
        int col = in.readInt();

        double[][] array = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i][j] = in.readDouble();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.printf("%-10.3f",array[i][j]);
            }
            StdOut.println();
        }

    }
}
