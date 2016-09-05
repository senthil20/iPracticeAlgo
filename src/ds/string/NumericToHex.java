package ds.string;

import java.util.HashMap;
import java.util.Map;

public class NumericToHex {

    public String convertNumToHex(int i)
    {
        String[] sym = new String[]{"(v)", "m(v)",  "m", "cm", "d", "cd", "c", "xc", "l", "xl", "x", "ix", "v", "iv", "i"};

        int[] val = new int[]{5000, 4000, 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String y = "";
        int v = 0;

        while(i > 0 && v < val.length) {
            int q = i / val[v];

            while(q > 0) {
                y += sym[v];
                q--;
            }
            i= i % val[v];
            v++;
        }
        return y;
    }

    public int convertHexToNum(String a) {

        int total = 0;

        if(a == null || a.length() == 0) return total;

        a = a.toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int i = 0;
        int e = a.length() - 1;

        while (i < e) {

            if (a.charAt(i) == a.charAt(i + 1)) {
                total += 2 * map.get(a.charAt(i));
                i = i + 2;
            }
            else if(map.get(a.charAt(i)) < map.get(a.charAt(i + 1))) {
                total += map.get(a.charAt(i + 1)) - map.get(a.charAt(i));
                i = i + 2;
            }
            else {
                total += map.get(a.charAt(i));
                i = i + 1;
            }
        }
        if(i == e) total += map.get(a.charAt(i));
        return total;
    }

    public String convert2Hex(int x) {

        String[] n= new String[]{"i", "v", "x", "l", "c", "d", "m"};

        int[] v= new int[]{1, 5, 10, 50, 100, 500, 1000};

        if (x < 1 || x > 4999) return null;

        String y = "";

        for (int i = 12; i >= 0;)
            if (v[i] <= x) {
                    y += n[i];
                    x -= v[i];
                }
            else {
                i--;
            }
        return y.toUpperCase();
    }


    public static void main(String a[]) {
        NumericToHex nh = new NumericToHex();
        //System.out.println(nh.convertNumToHex(4999));
        System.out.println(nh.convertHexToNum("MDCCCIV"));
    }
}
