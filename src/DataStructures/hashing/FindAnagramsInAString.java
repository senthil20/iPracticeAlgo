package DataStructures.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:
    s: "cbaebabacd" p: "abc"

 Output:
    [0, 6]

 Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 *
 * Input:
    s: "abab" p: "ab"

 Output:
    [0, 1, 2]

 Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAnagramsInAString {

    public List<Integer> findAnagrams(String a, String b) {

        List<Integer> result = new ArrayList<>();

        if (a == null || b == null) return result;

        int s = 0;
        int e = a.length() - b.length();

        while (s <= e) {
            String temp = a.substring(s, s + b.length());

            int[] arr = new int[26];

            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                arr[c - 'a']++;
            }

            for (int j = 0; j < b.length(); j++) {
                char c1 = b.charAt(j);
                arr[c1 - 'a']--;
            }

            boolean valid = true;

            for (int val : arr) {
                if (val != 0 ) valid = false;
            }
            if (valid) result.add(s);
            s++;
        }
        return result;
    }

    public static void main(String a[]) {
        FindAnagramsInAString fs = new FindAnagramsInAString();
        List<Integer> result = fs.findAnagrams("cbaebabacd", "abc");
        System.out.println(result);
    }
}
