package ds.arrays;

/**
 * Created by senthil on 2/9/16.
 */
public class ZigZagString {

    /*private String zigZagUsing2DMatrix(String str, int n) {

        if (str == null || str.length() == 0 && n < 2) return str;

        String result = "";
        char[][] a = new char[n][str.length()];

        int s = 0;
        int e = str.length();

        int dir = 0;
        int r = 0;
        int c = 0;

        while (s < e) {
            if (dir == 0) {
                while (r < n && c < e) {
                    a[r++][c++] = str.charAt(s++);
                }
                r--;
            }
            else if (dir == 1) {
                while (r > 0 && c < e) {
                    a[--r][c++] = str.charAt(s++);
                }
                r++;
            }
            dir = (dir == 0) ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {

            for(int j = i; j < str.length(); j++) {
                if (a[i][j] != 0) {
                    result += a[i][j];
                }

            }
        }
        return result;
    }*/

    private String zigZagString(String str, int n) {

        if (str == null || str.length() == 0 && n < 2) return str;

        String result = "";
        StringBuilder[] a = new StringBuilder[n];

        for (int i = 0; i < n; i++) {
            a[i] = new StringBuilder();
        }

        int s = 0;
        int e = str.length();

        boolean down = false;
        int r = 0;

        while (s < e) {
            a[r].append(str.charAt(s));

            if (r == 0) down = true;
            else if (r == n-1) down = false;

            if(down) r++;
            else r--;

            s++;
        }

        for (StringBuilder sb : a) {
            result += sb.toString();
        }
        return result;
    }

    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        StringBuilder builder = new StringBuilder();
        int step = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                for (int j = i; j < s.length(); j = j + step) {
                    builder.append(s.charAt(j));
                }
            } else {
                int j = i;
                boolean flag = true;
                int step1 = 2 * (nRows - 1 - i);
                int step2 = step - step1;
                while (j < s.length()) {
                    builder.append(s.charAt(j));
                    if (flag)
                        j = j + step1;
                    else
                        j = j + step2;
                    flag = !flag;
                }
            }
        }
        return builder.toString();
    }

    public String convert1(String a, int b) {

        if(a == null || a.length() == 0 || b < 2) return a;

        StringBuilder[] sb = new StringBuilder[b];

        for (int i = 0; i < b; i++) {
            sb[i] = new StringBuilder();
        }

        int s = 0;
        int e = a.length();
        String result = "";

        boolean d = true;

        int r = 0;

        while (s < e) {
            sb[r].append(a.charAt(s++));

            if(r == b - 1) {
                d = false;
            }
            else if (r == 0){
                d = true;
            }

            if(d) r++;
            else r--;
        }

        for (StringBuilder sbr : sb) {
            result += sbr.toString();
        }
        return result;
    }

    public static void main(String a[]) {
        ZigZagString zs = new ZigZagString();
        //System.out.println(zs.zigZagUsing2DMatrix("ABCDEFGH" 5));
        //System.out.println(zs.zigZagString("ABCDEFGH", 3));
        System.out.println(zs.convert1("ABCDEFGHIJKL", 4));
        //o/p is PAHNAPLSIIGYIR
    }
}
