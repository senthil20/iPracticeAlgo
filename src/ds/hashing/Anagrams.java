package ds.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : [geeksforgeeks, forgeeksgeeks]
 * Output : true
 */
public class Anagrams {

    public static boolean isAnagram2(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (int i = 0; i < input1.length(); i++) {
            arr[input1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < input2.length(); i++) {
            if (--arr[input2.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
    public static int reverseInt(int x) {

        int result = 0;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }
        return result;
    }


    // using counter if string is ASCII only
    public boolean isAnagram(String a, String b) {

        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;

        char[] arr = new char[26];

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

        return map.size() <= 0;
    }
    public static void main(String ar[]) {
        Anagrams an = new Anagrams();
        //System.out.println(an.isAnagram2("geeksforgeeks", "forgeeksgeeee"));
        System.out.println(Anagrams.reverseInt(-127));
    }

}
