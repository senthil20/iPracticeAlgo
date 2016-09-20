package ds.string;

/**
 * Created by senthil on 12/9/16.
 */
public class StringReverseRecursion {


    public String stringReverse(String s, int n) {

        String str = "";

        if(n >= s.length()) return str;

        char c = s.charAt(n);

        str = stringReverse(s, n+1);

        str += c;

        return str;

    }

    public static void main(String a[]) {

        StringReverseRecursion sr = new StringReverseRecursion();
        System.out.println(sr.stringReverse("tes1234", 0));

    }
}
