package ds.string;

/**
 Given a string, recursively compute a new string where the identical adjacent characters in the original string are separated by a "*".

 Examples:
 insertPairStar("cac") ==> "cac"

 insertPairStar("cc") ==> "c*c"
 */
public class InsertStars {

    public static String insertPairStar(String s) {
        if ("".equals(s)) return s;
        if (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
            s = s.charAt(0) + "*" + insertPairStar(s.substring(1));
        }
        else {
            s = s.charAt(0) + insertPairStar(s.substring(1));
        }
        return s;
    }

    public static void main(String a[]) {
        System.out.println(InsertStars.insertPairStar("aabcdddeef"));
    }
}
