package ds.MiscJava;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by User on 16-07-2017.
 */
public class OnlineTest1 {

    public static String test(String s) {

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        //s = s.replaceAll("[^\\w]", " ");
        //String[] str = s.split(" ");

        String[] str = s.split("[\\s,;.:-]+");
        for (String val : str) {
            val = val.replaceAll("[.,$]", "");
            if (map.containsKey(val)) {
                System.out.println(val);
                return val;
            }
            else {
                map.put(val, 1);
            }
        }
        return null;
    }

    public static void main(String ar[]) {
        OnlineTest1.test("Hi-How;;- are. you;,myfriend");
    }
}
