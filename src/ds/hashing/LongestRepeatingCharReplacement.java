package ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1
 * Input: s = "ABAB", k = 2
   Output: 4
   Explanation: Replace the two 'A's with two 'B's or vice versa.

 * Example 2
 * Input: s = "AABABBA", k = 1
   Output: 4
   Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
   The substring "BBBB" has the longest repeating letters, which is 4.
 */

public class LongestRepeatingCharReplacement {

    public int longestRepeatingCharReplacement(String s, int k) {

        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0;
        int b = k;
        int nextIndex = 0;
        map.put(s.charAt(0), 0);

        for (int j = 1; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            }
            else {
                if (k == 0) return j - i;
                b--;
                if (b == 0) {
                    max = Math.max(max, j - nextIndex);
                    while (j + 1 < s.length()) {
                        if (s.charAt(j) == s.charAt(j - 1)) {
                            j++;
                        }
                        else {
                            j = nextIndex + 1;
                        }
                    }

                }
            }
        }
        return max;
    }


    public static void main(String a[]) {

    }
}
