package DataStructures.string;

/**
 *
 * Given a string s and a string t, check if s is subsequence of t.

 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.

 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        if(sLen == 0) return true;
        if(tLen == 0) return false;

        int st = 0;
        int st1 = 0;
        int count = 0;

        while (st < sLen) {
            while (st1 < tLen) {
                if (s.charAt(st) == t.charAt(st1)) {
                    count++;
                    st1++;
                    break;
                }
                st1++;
            }
            st++;
        }
        return (count == sLen);
    }

    public static void main(String a[]) {
        IsSubsequence s = new IsSubsequence();
        s.isSubsequence("acd", "ahbgdc");
    }

}
