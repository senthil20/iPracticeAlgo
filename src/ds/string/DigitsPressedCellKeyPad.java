package ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 Given a String that represents the digits pressed on a classic cell
 phone keypad - return all possible letter combinations that the numbers could represent in an ArrayList of Strings.
 Check out the keypad and mapping below for reference.

 Note:
 a) You can assume that the input String contains only numbers between 2 and 9.
 b) The order of the combinations in the output does not matter.

 Mapping:
 2 -> "abc"
 3 -> "def"
 4 -> "ghi"
 5 -> "jkl"
 6 -> "mno"
 7 -> "pqrs"
 8 -> "tuv"
 9 -> "wxyz"

 Example:
 Input  : "34"
 Output : [dg, dh, di, eg, eh, ei, fg, fh, fi]

 **/
public class DigitsPressedCellKeyPad {

    public static ArrayList<String> getStringsFromNums(String digits) {
        ArrayList<String> result = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        recursiveCall(digits, digits, "", result, map);
        return result;
    }

    public static void recursiveCall(String orig, String digits, String temp, ArrayList<String> result, Map<Integer, String> map) {
        if (temp.length() == orig.length()) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < digits.length(); i++) {
            int d = Character.getNumericValue(digits.charAt(i));
            String num = map.get(d);
            for (int j = 0; j < num.length(); j++) {
                if (digits.length() > j + 1)
                    recursiveCall(orig, digits.substring(j + 1), temp + num.charAt(j), result, map);
            }
        }
    }

    public static void main(String ar[]) {
        ArrayList<String> result = DigitsPressedCellKeyPad.getStringsFromNums("34");
        System.out.println(result);
    }
}
