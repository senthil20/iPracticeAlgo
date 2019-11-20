package DataStructures.hashing;

import java.util.*;

/**
 Examples:
 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 Given "anviaj", output 5
 */
public class LongestSubstringWithoutRepeatingChars {

    public int longestSubstring(String str) {
        if (str == null || str.length() == 0) return -1;
        Set<Character> set = new HashSet<>();
        int max = 0;

        int index = 0;
        int s = 0;
        int e = str.length();

        while (s < e) {
            if (!set.contains(str.charAt(s))) {
                set.add(str.charAt(s++));
                max = Math.max(max, s - index);
            }
            else {
                set.remove(str.charAt(index++));
            }
        }
        return max;
    }

    // trying using deque
    public int longestSubStringNonRepeatingChars(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        LinkedList<Character> list = new LinkedList<>();
        int index = 0;
        int i = 0;
        int e = s.length();

        while (i < e) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i++));
                max = Math.max(max, i - index);
            }
            else {
                int idx = list.indexOf(s.charAt(index++));
                list.remove(idx);
            }
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    //Longest substring with 2(K) chars repeat
    public int lengthOfLongestSubstringKChars(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int index = 0;
        int max = 0;
        while (i < s.length()) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i++), 1);
                max = Math.max(max, i - index);
            }
            else if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) >= k) {
                    map.remove(s.charAt(index++));
                }
                else {
                    map.put(s.charAt(i), map.get(s.charAt(i++)) + 1);
                }
            }
        }
        return max;
    }

    public static void main(String a[]) {
        LongestSubstringWithoutRepeatingChars ls = new LongestSubstringWithoutRepeatingChars();
        //System.out.println(ls.longestSubstring("nvaiaj"));
        //System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(ls.longestSubstring("abbcd"));
        //System.out.println(ls.lengthOfLongestSubstring("nvaiajnpqsat"));
        //System.out.println(ls.longestSubStringNonRepeatingChars("abcdabdcea"));
        System.out.println(ls.lengthOfLongestSubstringKChars("aabbbccffdf", 2));
    }
}
