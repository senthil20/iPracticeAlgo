package ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : [geeksforgeeks, forgeeksgeeks]
 * Output : true
 */
public class Anagrams {

    // using counter if string is ASCII only
    public boolean isAnagram(String a, String b) {

        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            arr[c - 'a']++;
        }

        for (int j = 0; j < b.length(); j++) {
            char c1 = b.charAt(j);
            arr[c1 - 'a']--;
        }

        for (int val : arr) {
            if (val !=0 ) return false;
        }
        return true;
    }

    public boolean isAnagram1(String a, String b) {

        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }

        for (int j = 0; j < b.length(); j++) {
            char c1 = b.charAt(j);

            if(map.containsKey(c1)) {
                if (map.get(c1) == 1) {
                    map.remove(c1);
                }
                else
                    map.put(c1, map.get(c1) - 1);
            }
            else return false;
        }

        if (map.size() > 0) return false;
        return true;
    }
    public static void main(String a[]) {
        Anagrams an = new Anagrams();
        System.out.println(an.isAnagram1("geeksforgeeks", "forgeeksgeeks"));
    }
}
