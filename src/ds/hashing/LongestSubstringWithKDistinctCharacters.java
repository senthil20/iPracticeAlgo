package ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string you need to print longest possible substring that has exactly M unique characters.
   If there are more than one substring of longest possible length, then print any one of them.

 Examples:
 Given a string, find the longest substring that contains only two(k) unique characters.
 For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".

 "aabbcc", k = 1
 Max substring can be any one from {"aa" , "bb" , "cc"}.
 "aabbcc", k = 2
 Max substring can be any one from {"aabb" , "bbcc"}.
 "aabbcc", k = 3
 There are substrings with exactly 3 unique characters
 {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 Max is "aabbcc" with length 6.
 "aaabbb", k = 3
 There are only two unique characters, thus show error message.
 */

public class LongestSubstringWithKDistinctCharacters {

    //abcddeeefg
    public static int longestSubstringWithKDistinctCharacters(String s, int K) {
        if (s == null || s.length() == 0 || K < 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        int max = 0;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (!map.containsKey(s.charAt(start))) {
                if (map.size() == K) {
                    char ch = s.charAt(index);
                    int count = map.get(s.charAt(index));
                    while (count > 0 && ch == s.charAt(index)) {
                        map.put(ch, map.get(ch) - 1);
                        index++;
                        count--;
                    }
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    continue;
                }
                map.put(s.charAt(start++), 1);
                max = Math.max(max, start - index);
            }
            else {
                map.put(s.charAt(start), map.get(s.charAt(start++)) + 1);
                max = Math.max(max, start - index);
            }
        }
        return max;
    }

    public static void main(String a[]) {
        //System.out.println(longestSubstringWithKDistinctCharacters("abcddeeefg", 2));
        //System.out.println(longestSubstringWithKDistinctCharacters("abcddeeefg", 2));
        System.out.println(longestSubstringWithKDistinctCharacters("abcadcacacaca", 3));
    }
}
