package DataStructures.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 a)
 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].

 b)
 S: "lingmindraboofooowingdingbarrwingmonkeypoundcake"
 L: ["fooo","barr","wing","ding", "wing"]
 you should return the index : [13].
 */
public class SubstrWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        if(s==null||s.length()==0||words==null||words.length==0){
            return result;
        }
        //frequency of words
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String w: words){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else{
                map.put(w, 1);
            }
        }

        int len = words[0].length();

        for(int j=0; j<len; j++){
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;//start index of start
            int count = 0;//count total qualified words so far

            for(int i=j; i<=s.length()-len; i=i+len){
                String sub = s.substring(i, i+len);
                if(map.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    }else{
                        currentMap.put(sub, 1);
                    }
                    count++;

                    while(currentMap.get(sub)>map.get(sub)){
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + len;
                    }
                    if(count==words.length){
                        result.add(start); //add to result
                        //shift right and reset currentMap, count & start point
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                } else {
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static void main(String a[]) {
        SubstrWithConcatenationOfAllWords sw = new SubstrWithConcatenationOfAllWords();
        //sw.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        sw.findSubstring("lingmindraboofooowingwingdingbarrwingmonkeypoundcake",
                new String[]{"fooo", "barr", "wing", "ding"/*, "wing"*/});

    }
}
