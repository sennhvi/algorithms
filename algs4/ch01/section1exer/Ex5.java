/**
 * Created by sennhviwang
 * Time: 8:02 AM on 5/8/15
 * Not trying to handle Exceptions.
 */
public class Ex5 {
    /**
     * decide x between 0 and 1
     * @param x value to be decided
     * @return boolean value
     */
    public static boolean compare(double x) {
        if (x>0&&x<1)
            return  true;
        else
            return  false;
    }

    /**
     * main function.Input and Output
     * @param args do nothing
     */
    public static void main(String[] args) {
        StdOut.println("Please input double type variable x");
        double x = StdIn.readDouble();
        StdOut.println("Please input double type variable y");
        double y = StdIn.readDouble();
        StdOut.print(compare(x) && compare(y));
    }
}
