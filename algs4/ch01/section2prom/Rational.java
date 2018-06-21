/**
 * Created by sennhviwang
 * Time: 11:52 PM on 6/3/15
 * Not trying to handle Exceptions.
 * Rational numbers.
 * Using assertion to avoid value overflow
 * Ex16. Ex17.
 */
public class Rational {
    private final long nume;
    private final long deno;
    // constructor.
    public Rational(long numerator, long denominator) {
        if (denominator == 0) throw new RuntimeException("denominator cannot be 0.");
        this.nume = numerator / gcd(numerator, denominator);
        this.deno = denominator / gcd(numerator, denominator);
    }

    // get greatest common divisor.
    private static long gcd(long a, long b) {
        if (a % b == 0) return b;
        else return gcd(b, a%b);
    }

    // get least common multiple.
    private long lcm(long a, long b) {
        if (a * b == 0) return 0;
        else {
            long gcd = gcd(a, b);
            assert isOverflowTimes(a, b / gcd):"value overflow";
            return a * (b / gcd);
        }
    }

    public long numerator() {
        return this.nume;
    }

    public long denominator() {
        return this.deno;
    }

    // plus method. assert value overflow,
    public Rational plus(Rational that) {
        Rational a = new Rational(this.nume, this.deno);
        Rational b = new Rational(that.nume, that.deno);
        assert isOverflowPlus(this.deno, that.deno):"value overflow in plus or minus";
        assert isOverflowPlus(this.nume * that.deno, this.deno * that.nume):"value overflow in plus or minus";
        return new Rational((this.nume * b.deno + this.deno * b.nume), (this.deno * b.deno));
    }

    // reuse plus method.
    public Rational minus(Rational that) {
        Rational tmp = new Rational(-that.nume, that.deno);
        return this.plus(tmp);
    }

    // times method. assert value overflow.
    public Rational times(Rational that) {
        Rational a = new Rational(this.nume, this.deno);
        Rational b = new Rational(that.nume, that.deno);
        assert isOverflowTimes(a.nume, b.nume):"value overflow in times or divides";
        assert isOverflowTimes(a.deno, b.deno):"value overflow in times or divides";
        return new Rational(a.nume * b.nume, a.deno * b.deno);
    }

    // reuse times method.
    public Rational divides(Rational that) {
        Rational tmp = new Rational(that.deno, that.nume);
        return this.times(tmp);
    }

    // decide two objects are equal.
    public boolean equals(Rational that) {
        if (that == null) return false;
        if (that.getClass() != this.getClass()) return false;
        // constructor has guarantee number in simplest format.
        return (this.deno == that.deno && this.nume == that.nume);
    }

    // overwrite toString method.
    public String toString() {
        if (this.nume == 0) return 0 + "";
        else if (gcd(this.nume, this.deno) ==  this.deno) return this.nume/this.deno + "";
        else return this.nume + "/" + this.deno;
    }

    // decide if is overflow in plus method.
    private boolean isOverflowPlus(long a, long b) {
        return a >= 0 ? Long.MAX_VALUE - a > b : Long.MIN_VALUE - a < b;
    }

    // decide if is overflow in times method.
    private boolean isOverflowTimes(long a, long b) {
        if(a<0) a=-a;
        if(b<0) b=-b;
        if (a == 0||b==0)
            return false;
        else
            return  Long.MAX_VALUE / a > b;
    }

    public static void main(String[] args) {
        Rational testRa = new Rational(1230, 202000);
        Rational testRb = new Rational(2460, 404000);
        Rational result = testRa.plus(testRb);
        StdOut.println("plus result:" + result);
        result = testRa.minus(testRb);
        StdOut.println("minus result:" + result);
        result = testRa.times(testRb);
        StdOut.println("times result:" + result);
        result = testRa.divides(testRb);
        StdOut.println("divides result:" + result);
        boolean isequal = testRa.equals(testRb);
        StdOut.println("equal result:" + isequal);
        StdOut.println("toString()" + result.toString());
    }
}
