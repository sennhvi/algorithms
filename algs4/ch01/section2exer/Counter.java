/**
 * Created by sennhviwang
 * Time: 10:01 PM on 5/27/15
 * Not trying to handle Exceptions.
 * A simple Counter ADT.
 */
public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name = id;
    }
    public void increment() {
        count++;
    }
    public int tally() {
        return count;
    }
    public String toString() {
        return count + " " + name;
    }

}
