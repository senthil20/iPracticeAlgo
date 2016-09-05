package ds.string;


public class SwapCaps {

    public String swapCaps(String str) {

        if (str == null || str.length() == 0) return str;

        int s = 0;
        int e = str.length() - 1;

        while (s <= e) {

            while(s < e && str.charAt(s) >= 97 && str.charAt(s) <= 122) {
                s++;
            }

            while(e > 0 && str.charAt(e) >= 97 && str.charAt(e) <= 122) {
                e--;
            }
            if(str.charAt(s) >= 65 && str.charAt(s) <= 90 && str.charAt(e) >= 65 && str.charAt(e) <= 90) {
                str = swap(str, s, e);
            }
            s++;
            e--;
        }
        return str;
    }

    public String swap(String str, int s, int e) {
        StringBuilder sb = new StringBuilder(str);
        char temp = sb.charAt(s);
        sb.setCharAt(s, sb.charAt(e));
        sb.setCharAt(e, temp);
        return sb.toString();
    }

    public String swapByChar(String str, int s, int e) {
        char[] c = str.toCharArray();
        char temp = c[s];
        c[s] = c[e];
        c[e] = temp;
        return c.toString();
    }

    public static void main(String a[]) {
        SwapCaps sc = new SwapCaps();
        System.out.println(sc.swapCaps("DCEananananaP"));
    }
}
