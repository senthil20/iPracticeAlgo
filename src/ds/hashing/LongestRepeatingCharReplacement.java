package ds.hashing;

/**
 * Example 1
 * Input: s = "ABAB", k = 2
   Output: 4
   Explanation: Replace the two 'A's with two 'B's or vice versa.

 * Example 2
 * Input: s = "AABABBA", k = 1
   Output: 4
   Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
   The substring "BBBB" has the longest repeating letters, which is 4.
 */

public class LongestRepeatingCharReplacement {
    //s = "AABABBA", k = 1
    public static int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            int start = 0;
            int index = 0;
            int count = 0;
            while (start <= s.length() - 1) {
                char ch = s.charAt(start++);
                if (ch != c) {
                    count++;
                }
                while (count > k) {
                    if (s.charAt(index) != c) {
                        count--;
                    }
                    index++;
                }
                max = Math.max(max, start - index);
            }
        }
        return max;
    }

    //s = "AABABBA", k = 1
    public static int characterReplacement1(String s, int k) {
        int maxLen = 0;
        for(int l = 0 ; l<26;l++){
            char c = (char)('A' + l); //repeated char we are looking for
            int i = 0, j = 0, count = 0;
            while(j<s.length()){
                char cur = s.charAt(j);
                if(cur != c) {
                    count++;
                }
                //make the substring valid again
                while(count > k){
                    if(s.charAt(i) != c) {
                        count--;
                    }
                    i++;
                }

                //update maximun len
                maxLen = Math.max(maxLen,j-i+1);
                j++;
            }
        }
        return maxLen;
    }

    public static void main(String a[]) {
        System.out.println(characterReplacement("AABABBA", 1));
        System.out.println(characterReplacement1("ABBB", 2));
        System.out.println(characterReplacement1("ABAB", 2));
        System.out.println(characterReplacement1("AAAB", 0));
        System.out.println(characterReplacement1("AABA", 0));
        System.out.println(characterReplacement1("ABAA", 0));
    }
}
