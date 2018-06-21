/**
 * Created by sennhviwang
 * Time: 10:02 AM on 5/6/15
 * Not trying to handle Exceptions.
 */
public class Ex3 {
    /**
     * Handle three args and yield result.
     */
    public static void compare(int[] args){
        if (args[0] == args[1]&& args[1] == args[2])
            StdOut.println("equal");
        else
            StdOut.println("not equal");

    }

    /**
     * main function.convert String type to Integer type
     */
    public static void main(String[] args) {
        int[] array = new int[3];

        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(args[i]);
        }
        compare(array);
    }
}
