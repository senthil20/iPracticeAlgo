package ds.string;

import java.util.ArrayList;

/**
 Write a method to return all valid combinations of n-pairs of parentheses.

 The method should return an ArrayList of strings, in which each string represents a valid combination of parentheses.

 The order of the strings in the ArrayList does not matter.

 Examples:
 combParenthesis(2) ==> {"(())","()()"}

 Note: Valid combination means that parentheses pairs are not left open. ")()(" is not a valid combination.
 */
class CombParenthesis {

    public static ArrayList<String> combParenthesis(int pairs) {
        ArrayList<String> res = new ArrayList<String>();
        if (pairs > 0) {
            combParenthesis(pairs,pairs,"",res);
        }
        return res;
    }

    public static void combParenthesis(int left, int right, String tmp, ArrayList<String> res) {
        if (left == 0 && right == 0) {
            res.add(tmp);
        }
        else {
            if (left > 0) {
                combParenthesis(left-1,right,tmp+"(", res);
            }
            if (right > left) {
                combParenthesis(left,right-1,tmp+")", res);
            }
        }
        return;
    }

    public static void main(String a[]) {
        CombParenthesis cp = new CombParenthesis();
        System.out.println(cp.combParenthesis(3));
    }
}
