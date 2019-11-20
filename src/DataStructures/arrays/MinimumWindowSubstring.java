package DataStructures.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

    public static String minWindow2(String s, String t) {
        if(t.length()>s.length())
            return "";
        String result = "";
        //character counter for t
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);
            }
        }
        // character counter for s
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int minLen = s.length()+1;
        int count = 0; // the total of mapped characters

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
            if(count == t.length()){
                char sc = s.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    sc = s.charAt(left);
                }
                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        String result = "";
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (target.containsKey(c)) {
                target.put(c, target.get(c) + 1);
            }
            else
                target.put(c, 1);
        }
        int count = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> source = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (target.containsKey(c)) {
                if (source.containsKey(c)) {
                    if (source.get(c) < target.get(c)) {
                        count++;
                    }
                    source.put(c, source.get(c) + 1);
                }
                else {
                    source.put(c, 1);
                    count++;
                }

            }
            if (count == t.length()) {
                char ch = s.charAt(left);
                while (!target.containsKey(ch) || source.get(ch) > target.get(ch)) {
                    if (target.containsKey(ch) && source.get(ch) > target.get(ch)) {
                        source.put(ch, source.get(ch) - 1);
                    }
                    left++;
                    ch = s.charAt(left);
                }
                if (i - left + 1 < minLength) {
                    minLength = i - left + 1;
                    result = s.substring(left, i + 1);
                }
            }

        }
        return result;
    }

    public static void main(String a[]) {
        String result = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
        result = minWindow("ADOBECODEBANA", "AA");
        System.out.println(result);
    }
}
