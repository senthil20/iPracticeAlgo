package DataStructures.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 Input : ["eat", "tea", "tan", "ate", "nat", "bat"],

 Output :
    [
        ["ate", "eat","tea"],
        ["nat","tan"],
        ["bat"]
    ]
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] s) {

        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        if (s == null || s.length == 0) return result;

        for (String st : s) {
            char[] arr = new char[26];

            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);
                arr[c - 'a']++;
            }
            String temp = new String(arr);

            if (map.containsKey(temp)) {
                map.get(temp).add(st);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(st);
                map.put(temp, list);
            }
        }
        result.addAll(map.values());
        return result;
    }

    public static void main(String a[]) {
        GroupAnagrams ga = new GroupAnagrams();
        ga.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
