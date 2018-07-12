package ds.string;

/**
 Implement strStr().
 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 Example 1:
 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:
 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 Clarification:
 What should we return when needle is an empty string? This is a great question to ask during an interview.
 For the purpose of this problem, we will return 0 when needle is an empty string.
 This is consistent to C's strstr() and Java's indexOf().
*/

public class Strstr {
    // ask whether char case sensitive
    public int strStr(final String haystack, final String needle) {
        int s = 0;
        int e = haystack.length();
        int s1 = 0;
        int e1 = needle.length();
        while (s <= (e-e1)) {
            s1 = 0;
            while (s1 < e1) {
                if (haystack.charAt(s+s1) != needle.charAt(s1)) {
                    break;
                }
                else {
                    s1++;
                }
            }
            if (s1 == e1) return s;
            s++;
        }
        return -1;
    }
    /*if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int h = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= h-n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }

            if(j == n)
                return i;
        }
        return -1;*/

    public static void main(String a[]) {
        Strstr st = new Strstr();
        System.out.println(st.strStr("InterviewBitAwesome", "Bit"));
    }
}
