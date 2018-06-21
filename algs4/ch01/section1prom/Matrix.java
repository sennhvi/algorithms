/**
 * Created by sennhviwang
 * Time: 3:49 PM on 5/20/15
 * Not trying to handle Exceptions.
 * Matrix library. Write a library Matrix that implements the following API:
 * public class Matrix
 * static double dot(double[] x, double[] y) vector dot product
 * static double[][] mult(double[][] a, double[][] b) matrix-matrix product
 * static double[][] transpose(double[][] a) transpose
 * static double[] mult(double[][] a, double[] x) matrix-vector product
 * static double[] mult(double[] y, double[][] a) vector-matrix product
 *
 * Develop a test client that reads values from standard input and tests all the methods.
 */
public class Matrix {
    /**
     * vector dot product.
     * @param x vector x.
     * @param y vector y.
     * @return return result of vector dot product.
     */
    public static double dot(double[] x, double[] y) {
        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
                result += (x[i] * y[i]);
        }
        return result;
    }

    /**
     * multiplication of matrix a and matrix b.
     * @param a matrix a.
     * @param b matrix b.
     * @return result a matrix.
     */
    public static double[][] mult(double[][] a, double[][] b) {
        double[][] result = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                result[i][j] = dot(a[i], (transpose(b)[j]));
            }
        }
        return result;
    }

    /**
     * transpose matrix.
     * @param a matrix a.
     * @return return a transposed matrix.
     */
    public static double[][] transpose(double[][] a) {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }
        return result;
    }

    /**
     * multiplication of matrix a and vector x.
     * @param a matrix a.
     * @param x vector x.
     * @return return a new vector.
     */
    public static double[] mult(double[][] a, double[] x) {
        double[][] y = new double[x.length][1];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < 1; j++) {
                y[i][j] = x[i];
            }
        }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 1; j++) {
                result[i] = dot(a[i],transpose(y)[0]);
            }
        }
        // i rows,1 cols
        return result;
    }

    public static double[] mult(double[] y, double[][] a) {
        double[] result = new double[a[0].length];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j] = dot(y, transpose(a)[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        In in = new In();

        StdOut.println("Input number of elements in vector:");
        int vectorNum = in.readInt();

        StdOut.println("Input vector x:");
        double[] vectorX = new double[vectorNum];
        for (int i = 0; i < vectorNum; i++) {
            StdOut.print("vector[" + i + "]:");
            vectorX[i] = in.readDouble();
        }
        StdOut.println("vector X input done.");

        double[] vectorY = new double[vectorNum];
        for (int i = 0; i < vectorNum; i++) {
            StdOut.print("vector[" + i + "]:");
            vectorY[i] = in.readDouble();
        }

        StdOut.println("vector Y input done.");

        StdOut.println("Input matrix args:");
        StdOut.println("rows:");
        int row = in.readInt();
        StdOut.println("cols:");
        int col = in.readInt();
        StdOut.println("Input matrix A:(you need to assign its row == col if you want calculate all,just for test:)");

        double[][] matrixA = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.print("array[" + i + "]" + "[" + j + "]" );
                matrixA[i][j] = in.readDouble();
            }
        }
        StdOut.println("Your input matrix A:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.printf("%-10.3f",matrixA[i][j]);
            }
            StdOut.println();
        }
        StdOut.println("Input matrix B: (its col number is free to assign");
        double[][] matrixB = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.print("array[" + i + "]" + "[" + j + "]" );
                matrixB[i][j] = in.readDouble();
            }
        }
        StdOut.println("Your input matrix B:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                StdOut.printf("%-10.3f", matrixB[i][j]);
            }
            StdOut.println();
        }

        StdOut.println("-------- Vector dot production (vector x and vector y) ---------");
        StdOut.println(dot(vectorX, vectorY));

        StdOut.println("-------- Matrix multiplication (matrix A and matrix B) ---------");
        double[][] resultMatrixMult = mult(matrixA, matrixB);
        for(int i = 0; i < resultMatrixMult.length; ++i) {
            for (int j = 0; j < resultMatrixMult[i].length; ++j)
                StdOut.printf("%-10.3f", resultMatrixMult[i][j]);
            StdOut.println();
        }

        StdOut.println("-------- Transpose matrix (matrix A) ---------");
        double[][] resultMatrixTranspose= transpose(matrixA);
        for(int i = 0; i < resultMatrixTranspose.length; ++i) {
            for (int j = 0; j < resultMatrixTranspose[i].length; ++j)
                StdOut.printf("%-10.3f", resultMatrixTranspose[i][j]);
            StdOut.println();
        }

        StdOut.println("----- Product of a matrix and a vector (matrix A and vector X) ------");
        double[] resultMatrixVector= mult(matrixA, vectorX);
        for(int i = 0; i < resultMatrixVector.length; ++i)
            StdOut.printf("%-10.3f\n", resultMatrixVector[i]);

        StdOut.println("----- Product of a vector and a matrix (vector Y and matrix A------");
        double[] resultVectorMatrix = mult(vectorY, matrixA);
        for(int i = 0; i < resultVectorMatrix.length; ++i)
            StdOut.printf("%-10.3f", resultVectorMatrix[i]);

    }
}
