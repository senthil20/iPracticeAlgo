package DataStructures.string;

import java.util.ArrayList;

/**
 * Created by User on 12-07-2017.
 */
public class PermutationCombinationString {

    public static ArrayList<String> getCombPerms(String s) {
        ArrayList<String> permutations = new ArrayList<String>();
        if (s == null)  return null;    // error case
        else if (s.length() == 1) {     // base case
            permutations.add(s);
            return permutations;
        }
        String first = s.substring(0,1);    // get and add the first character
        permutations.add(first);
        String remainder = s.substring(1);  // remove the first character
        ArrayList<String> words = getCombPerms(remainder);
        // Insert the first character into each possible position in permutation
        for (String word : words)
            for (int j = 0; j <= word.length(); j++)
                permutations.add(insertCharAt(word, first, j));
        permutations.addAll(words);     // add permutations without the first character
        return permutations;
    }

    public static String insertCharAt(String word, String c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String a[]) {
        ArrayList<String> result = PermutationCombinationString.getCombPerms("abc");
        System.out.println(result);

    }
}
