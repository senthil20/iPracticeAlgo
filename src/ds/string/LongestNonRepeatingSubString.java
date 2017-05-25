package ds.string;

import java.util.HashMap;
import java.util.Map;

/**
 Given a String input, find the length of the longest substring that is made up of non-repeating characters.
 For ex, the longest substrings without repeated characters in “BCEFGHBCFG” are “CEFGHB” and “EFGHBC”, with length = 6.
 In the case of "FFFFF", the longest substring is "F" with a length of 1.

 Example:
 Input : aaabbbabcde
 Output: 5
 */
public class LongestNonRepeatingSubString {

    public static int longestNRSubstringLen(String input) {
        if (input == null || input.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        int i = 0;
        for (;i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                start = Math.max(start, map.get(input.charAt(i)));
                max = Math.max(max, i - start);
                start++;
            }
            else
                map.put(input.charAt(i), i);
        }
        return max == 0 ? (i - start) : max;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String a[]) {
        //System.out.println(LongestNonRepeatingSubString.longestNRSubstringLen("BCEFGHBCFG"));
        //System.out.println(LongestNonRepeatingSubString.longestNRSubstringLen("FFFFFF"));
        System.out.println(LongestNonRepeatingSubString.longestNRSubstringLen("abc"));
    }

}
