package DataStructures.string;

/**
 Given a string, recursively compute a new string where the identical adjacent characters in the original string are separated by a "*".

 Examples:
 insertPairStar("cac") ==> "cac"

 insertPairStar("cc") ==> "c*c"
 */
public class InsertStars {

    public static String insertPairStar(String s) {
        if (s == null || s.length() < 2) return s;
        if (s.charAt(0) == s.charAt(1))
            s = s.charAt(0) + "*" + insertPairStar(s.substring(1));
        else
            s = s.charAt(0) + insertPairStar(s.substring(1));
        return s;
    }

    //from firecode
    public static String insertPairStar1(String s) {
        if (s == null || s.length() < 2) return s;
        return s.charAt(0) + (s.charAt(0)==s.charAt(1) ? "*" : "") + insertPairStar(s.substring(1));
    }

    public static void main(String a[]) {
        System.out.println(InsertStars.insertPairStar("aabcdddeef"));
    }
}
