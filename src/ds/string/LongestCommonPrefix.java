package ds.string;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 a) As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 b) ["abcdefgh", "aefghijk", "abcefgh"] is "a".

 Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 */

public class LongestCommonPrefix {

    //Method 1 - Vertical scanning. Comparing char by char.
    //Time complexity : O(S), where S is the sum of all characters in all strings.
    //In the worst case there will be nn equal strings with length mm and the algorithm performs S = m*n character comparisons.
    public String longestCommmonPrefix(String a[]) {

        String temp = "";
        if (a == null || a.length == 0) return temp;
        int max = 0;
        int minLen = findMinLen(a);

        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                String s1 = a[j];
                String s2 = a[j + 1];

                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
        }
        return a[0].substring(0, minLen);
    }


    public int findMinLen(String a[]) {

        int min = Integer.MAX_VALUE;
        for (String s : a) {
            min = Math.min(min, s.length());
        }
        return min;
    }

    /*Method 2 - Divide and Conquer
         {leetcode, leet, lee, le}
              /             \
      {leetcode, leet}     {lee, le}
           /                 \
         {leet}              {le}
            \                 /
                    {le}
    */

    public String longestCommonPrefix1(String a[]) {

        if (a == null || a.length == 0) return "";
        return recursiveCall(a, 0, a.length - 1);
    }

    public String recursiveCall(String a[], int s, int e) {

        if (s == e) return a[s];
        int mid = s + (e - s) / 2;

        String s1 = recursiveCall(a, s, mid);
        String s2 = recursiveCall(a, mid + 1, e);

        String str = getCommonString(s1, s2);

        if (str.length() == 0) return "";
        return str;
    }

    public String getCommonString(String s1, String s2) {

        int st = 0;
        int en = s1.length();
        int st1 = 0;
        int en1 = s2.length();

        while (st < en && st1 < en1) {
            if (s1.charAt(st) == s2.charAt(st1)) {
                st++;
                st1++;
            }
            else break;
        }
        return s1.substring(0, st);
    }

    public static void main(String a[]) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        //System.out.println(lcp.longestCommmonPrefix(new String[]{"abcdefgh", "abcefgh", "abcdhj", "b"}));
        System.out.println(lcp.longestCommonPrefix1(new String[]{"abcdefgh", "abcefgh", "abcdhj", "abcd"}));
    }
}
