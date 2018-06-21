/**
 * Created by sennhviwang
 * Time: 11:21 PM on 5/30/15
 * Not trying to handle Exceptions.
 * A string s is a circular rotation of a string t if it matches when the characters
 * are circularly shifted by any number of positions;
 * e.g., ACTGACG is a circular shift of TGACGAC , and vice versa.
 * Detecting this condition is important in the study of genomic sequences.
 * Write a program that checks whether two given strings s and t are circular shifts of one another.
 * Hint : The solution is a one-liner with indexOf() , length() , and string concatenation.
 */
public class Ex06 {
    public static void main(String[] args) {
        StdOut.println("Input first string: s");
        String s = StdIn.readString();
        StdOut.println("Input second string: t");
        String t = StdIn.readString();

        if ((t.length() == s.length()) && (s.concat(s).indexOf(t) >= 0))
            StdOut.println("circular shift");
        else StdOut.println("no circular shift");
    }
}
