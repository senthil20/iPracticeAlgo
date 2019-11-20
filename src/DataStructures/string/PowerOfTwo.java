package DataStructures.string;

/**
 * Created by senthil on 13/9/16.
 */
public class PowerOfTwo {

    /*public int power1(String a) {

        if (a == null || a.length() == 0) return 0;

        String result = "1";

        while (result.length() < a.length() || (result.length() == a.length() && result.charAt(0) <= a.charAt(0))) {

            int len = result.length() - 1;
            int rem = 0;

            StringBuffer sb = new StringBuffer();

            while (len >= 0 || rem > 0) {

                int d = len >=0 ? Integer.parseInt(Character.toString(result.charAt(len))) : 0;
                int n = 2 * d + rem;

                sb.insert(0, n % 10);
                rem = n / 10;
                len--;
            }

            result = sb.toString();

            if(result.equals(a)) return 1;

        }
        return 0;
    }*/

    public static void main(String a[]) {
        PowerOfTwo pt = new PowerOfTwo();
    }
}
