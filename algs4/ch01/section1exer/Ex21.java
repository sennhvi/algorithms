/**
 * Created by sennhviwang
 * Time: 12:03 PM on 5/9/15
 * Not trying to handle Exceptions.
 */
public class Ex21 {
    public static void main( String[] args) {
        StdOut.println("Input name-first integer-second integer:");
        /**
         * StdIn.readAllStrings() can be replace by using In class:
         * In in = new In(); + in.readAllStrings();
         */
        String[] inputString = StdIn.readAllStrings();
        for (int i = 0; i < inputString.length; i+=3) {
            StdOut.print(inputString[i]+ " " + inputString[i+1] + " " + inputString[i+2] + " ");
            double m = Double.parseDouble(inputString[i+1]);
            double n = Double.parseDouble(inputString[i+2]);
            StdOut.printf("%.3f", m / n);
            StdOut.println();
        }
    }
}
