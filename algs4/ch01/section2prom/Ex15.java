/**
 * Created by sennhviwang
 * Time: 2:48 PM on 6/3/15
 * Not trying to handle Exceptions.
 * File input.
 */
public class Ex15 {
    public static int[] readInts(String name) {
        // Read from txt file.
        In in = new In(name);
        String input = in.readAll();
        String[] fields = input.split("\\s+");

        int[] ints = new int[fields.length];
        for (int i = 0; i < fields.length; i++)
            ints[i] = Integer.parseInt(fields[i]);
        return ints;
    }

    public static void main(String[] args){
        int[] example = new Ex15().readInts("Ex15.txt");
        for (int i = 0; i < example.length; i++) {
            StdOut.println(example[i]);
        }
    }
}
