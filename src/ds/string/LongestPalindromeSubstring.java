package ds.string;

/**
 * Created by senthil on 9/9/16.
 */
public class LongestPalindromeSubstring {

    public String getCurrentMax(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }

    public String longestPalindrome(String a) {
        if (a == null || a.length() == 0) return null;
        if(a.length() == 1) return a;

        String longest = a.substring(0,1);
        int s = 0;
        int e = a.length();

        while (s < e) {
            String currentMax = getCurrentMax(a, s, s);
            longest = currentMax.length() > longest.length() ? currentMax : longest;

            currentMax = getCurrentMax(a, s, s+1);
            longest = currentMax.length() > longest.length() ? currentMax : longest;
            s++;
        }
        return longest;
    }

    public static void main(String a[]) {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        System.out.println(lps.longestPalindrome("12"));
    }
}
