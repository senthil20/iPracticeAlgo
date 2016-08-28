package ds.string;

/**
 * Created by senthil on 27/8/16.
 */
public class Palindrome {

    public boolean isPalindrome(String str) {

        if (str == null || str.length() == 0) return true;

        str = str.replaceAll("[^\\w]", "").toLowerCase();
        int s = 0;
        int e = str.length()-1;

        while (s < e) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static void main(String a[]) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("A man123##, a canal--: Panama"));
    }
}
