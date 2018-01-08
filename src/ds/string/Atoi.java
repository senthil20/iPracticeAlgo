package ds.string;

public class Atoi {

    /**
     * Input:
     "2147483648"
     Output:
     -2147483648
     Expected:
     2147483647
     "       010" --> 10
     */
    public int atoi(String str) {
        if (str == null || str.length() < 1) return 0;

        str = str.trim();

        double result = 0;
        int s = 0;
        char f = '+';

        if (str.charAt(s) == '-') {
            f = '-';
            s++;
        }
        else if (str.charAt(s) == '+')
            s++;

        while (s < str.length() && str.charAt(s) >= '0' && str.charAt(s) <= '9') {
            result = result * 10 + Character.getNumericValue(str.charAt(s)); //or result = result * 10 + (str.charAt(s) - '0');
            s++;
        }

        if (f == '-') result = -result;

        if (result > Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;

        else if (result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String a[]) {
        int val = -1;
        System.out.println(Math.abs(val));
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoi("-54332872018247709407 4 54"));
    }
}
