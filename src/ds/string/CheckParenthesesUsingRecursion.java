package ds.string;

import java.util.HashMap;
import java.util.Map;

public class CheckParenthesesUsingRecursion {

    public static boolean isBalanced(String input) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        return isBalancedRecursion(input, 0, ' ', map, true);
    }

    public static boolean isBalancedRecursion(String input, int index, char prev, Map<Character, Character> map, boolean isParentheses) {
        if (input.length() == 0) return true;
        if (!isParentheses) return false;
        char c = input.charAt(index);
        if (c == '(' || c == '[' || c == '{') {
            isParentheses = isBalancedRecursion(input, index + 1, c, map, isParentheses);
        }
        else if (map.get(c) == prev) {
            StringBuilder sb = new StringBuilder(input);
            sb.deleteCharAt(index);
            sb.deleteCharAt(index - 1);
            if (index > 1) {
                prev = sb.charAt(index - 2);
            }
            input = sb.toString();
            isParentheses = isBalancedRecursion(input, index - 1, prev, map, isParentheses);
        }
        else {
            return false;
        }
        return isParentheses;
    }

    public static void main(String a[]) {
        System.out.println(CheckParenthesesUsingRecursion.isBalanced("(("));
    }

}
