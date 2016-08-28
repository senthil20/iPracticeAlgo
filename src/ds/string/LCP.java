package ds.string;

import ds.arrays.MergeSort;

public class LCP {

    public int findMin(String a[]) {

        int min = Integer.MAX_VALUE;

        for(String str : a) {
            if(str.length() < min)
                min = Math.min(min, str.length());
        }
        return min;
    }

    //o(mn)
    public String LCP(String[] a) {

        int findMin = findMin(a);

        for (int i = 0; i < findMin; i++) {

            for(int j = 0; j < a.length - 1; j++) {

                char s  = a[j].charAt(i);
                char s1 = a[j+1].charAt(i);

                if(s != s1) {
                    return a[i].substring(0, i);
                }
            }
        }
        return a[0].substring(0, findMin);
    }

    //using binary search and char/char matching
    //o(mn)
    public String lcp(String[] a, int s, int e) {
        if(s == e) return a[s];

        if(e > s) {
            int mid = s + (e-s)/2;
            String s1 = lcp(a, s, mid);
            String s2 = lcp(a, mid+1, e);
            //String t =  compareChars(s1, s2);
            //return t;
            return compareChars(s1, s2);
        }
        return null;
    }

    public String compareChars(String s1, String s2) {

        int st = 0;
        int st1 = 0;
        String s;
        while (st < s1.length() && st1 < s2.length()) {

            if(s1.charAt(st) != s2.charAt(st1)) {
                return s1.substring(0, st);
            }
            st++;
            st1++;
        }
        return s1.substring(0, st);
    }

    public static void main(String a[]) {
        LCP lcp = new LCP();
        //System.out.println(lcp.LCP(new String[]{"geeksforgeeks", "geeks", "k", "geekstr"}));
        //System.out.println(lcp.lcp(new String[]{"geeksforgeeks", "geeks", "gee", "geekstr"}, 0, 3));
    }
}