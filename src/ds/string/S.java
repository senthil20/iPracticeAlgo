package ds.string;

import java.util.HashMap;

/**
 * Created by senthil on 21/8/16.
 */
public class S {

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

    public static void main(String a[]) {
        S s = new S();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }

}
