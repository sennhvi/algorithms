/**
 * Created by sennhviwang
 * Time: 5:24 PM on 6/1/15
 * Not trying to handle Exceptions.
 * Ex11 & Ex12
 * Develop an implementation SmartDate of our Date API that raises
 * an exception if the date is not legal.
 */
public class SmartDate{
    private final int month;
    private final int day;
    private final int year;

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String dayOfTheWeek() {
        // Zeller's congruence.
        int w = (year/100/4 - 2 * (year / 100) + year % 100 + year % 100 / 4 + 26 * (month + 1) / 10 + day - 1) % 7;
        switch (w) {
            case 1: return "Monday";
            case 2: return "Tuesday";
            case 3: return "Wednesday";
            case 4: return "Thursday";
            case 5: return "Friday";
            case 6: return "Saturday";
            default: return "Sunday";
        }
    }

    private static boolean isLeapYear(int y) {
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 ==0);
    }

    private boolean isIllegal(int m, int d, int y) {
        if (y < 0 || d < 1 || d > 31) return true;
        if (m > 12 || m < 0) return true;
        int[] monthofdays = {0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(y)) {
            monthofdays[2] = 29;
        }else monthofdays[2] = 28;
        if (d > monthofdays[m]) return true;
        else return false;
    }

    // Constructor
    public SmartDate(int m, int d, int y) {
        if (isIllegal(m,d,y)){
            throw new IllegalArgumentException("Illegal date");
        }else {
            month = m;
            day = d;
            year = y;
        }
    }

    public String toString() {
        return (month() + "/" + day() + "/" + year());
    }

    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (x == null)
            return false;
        if (this.getClass() != x.getClass())
            return false;
        SmartDate that = (SmartDate)x;
        if (this.day != that.day)
            return false;
        if (this.month != that.month)
            return false;
        if (this.year != that.year)
            return false;
        return true;
    }
}
