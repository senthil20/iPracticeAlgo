package DataStructures.string;

/**
 * Created by senthil on 14/9/16.
 */
public class Add2BinaryStrings {

    public String add2Binary(String a, String b) {

        if (a == null && b == null && a.length() == 0 && b.length() == 0) return null;
        if (a == null && a.length() == 0) return b;
        if (b == null && b.length() == 0) return a;

        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        int e = a.length() > b.length() ? a.length() - 1 : b.length() - 1;

        int rem = 0;
        int quotient = 0;

        StringBuffer sb = new StringBuffer();

        while (e >= 0) {

            int aVal = 0;
            int bVal = 0;

            if (aIndex >= 0) {
                aVal = Integer.valueOf(""+a.charAt(aIndex));
                aIndex--;
            }
            if (bIndex >= 0) {
                bVal = Integer.valueOf(""+b.charAt(bIndex));
                bIndex--;
            }

            quotient = (aVal + bVal + rem) % 2;
            rem = (aVal + bVal + rem) / 2;

            sb.insert(0, quotient);
            e--;
        }
        if (rem != 0) sb.insert(0, rem);

        return sb.toString();
    }

    public static void main(String a[]) {
        Add2BinaryStrings ab = new Add2BinaryStrings();
        System.out.println(ab.add2Binary("11110001", "1111"));
    }
}
