package ds.arrays;


import java.util.*;
import java.util.Arrays;

public class FindLargest {

    public int findLargest(int a[]) {

        if(a == null || a.length == 0) return 0;
        String[] s = new String[a.length];
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < a.length; i++) {
            s[i] = String.valueOf(a[i]);
        }

        Arrays.sort(s, new Comparator<String>(){
            public int compare(String s1, String s2) {
                System.out.println("S1 is " + s1 + "..." + " S2 is" + s2);
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(String str : s) {
            sb.append(str);
        }

        while(sb.charAt(0) =='0' && sb.length() > 1)
            sb.deleteCharAt(0);

        return Integer.parseInt(sb.toString());
    }

    public static void main(String a[]) {
        FindLargest fl = new FindLargest();
        fl.findLargest(new int[]{3, 30, 34, 5, 9});
    }
}
