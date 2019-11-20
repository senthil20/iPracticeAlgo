package DataStructures.string;

import java.util.Stack;

/**
 * Given an encoded string, return it's decoded string.

 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "3[abc2[c]]" return "abcccabcccabccc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 s = "2[2[b]]", return bbbb.
 s = "100[b]", return 100 b's.
 */

public class DecodeString {

    public String decodeString(String str) {

        int s = 0;
        int e = str.length();
        Stack<Character> st = new Stack<>();
        Stack<String> n = new Stack<>();
        String digit = "";

        String ret = "";

        while (s < e) {
            char c = str.charAt(s++);

            if(Character.isDigit(c)) {
                digit += c;
                continue;
            }
            else if (c != ']') {
                st.push(c);
                if(digit != "") n.push(digit);
                digit = "";
            }
            else {
                int num = !n.isEmpty() ? Integer.valueOf(n.pop()) : 0;
                String result = "";

                while (!st.isEmpty() && st.peek() != '[') {
                    result = st.pop() + result;
                }
                if(!st.isEmpty()) st.pop();

                while (num > 0) {
                    for(int i = 0; i < result.length(); i++) {
                        st.push(result.charAt(i));
                    }
                    num--;
                }
            }
        }

        for(int i = 0; i < st.size(); i++) {
            ret += st.get(i);
        }
        return ret;
    }



    public static void main(String a[]) {
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString("200[2000[b]]"));
    }

}
