package DataStructures.string;

import java.util.HashMap;

/**
 * Created by senthil on 21/8/16.
 */
public class UniqueChars_ReverseString {

    public int firstUniqChar(String s) {

       /* if(s.length() > 256) return -1;

        boolean[] c = new boolean[256];

        for(int i = 0 ; i < s.length(); i++) {
            int val = s.charAt(i);

            if(c[val]) {
                return i;
            }
            c[val] = true;
        }
        return -1;*/

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i=0; i < s.length(); i++) {

            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public String reverseString(String str) {
        if(str == null || str.length() < 2) return str;

        str = str.trim();

        char c[] = str.toCharArray();
        int s = 0;
        int e = c.length - 1;

        while(s < e) {
            swap(c, s, e);
            s++;
            e--;
        }
        return new String(c);
    }

    public void swap(char[] c, int s, int d) {
        char t = c[s];
        c[s] = c[d];
        c[d] = t;
    }

    public static void main(String a[]) {
        UniqueChars_ReverseString s = new UniqueChars_ReverseString();
        //System.out.println(s.firstUniqChar("loveleetcode"));
        //System.out.println(s.reverseString("lihtnes si siht ih"));
    }
}