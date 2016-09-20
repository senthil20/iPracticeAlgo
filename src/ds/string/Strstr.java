package ds.string;

/**
 * Created by senthil on 13/9/16.
 */
public class Strstr {

    // ask whether char case sensitive
    public int strStr(final String haystack, final String needle) {

        int s = 0;
        int e = haystack.length();

        int s1 = 0;
        int e1 = needle.length();

        while (s <= (e-e1)) {
            s1 = 0;
            while (s1 < e1) {
                if (haystack.charAt(s+s1) != needle.charAt(s1)) {
                    break;
                }
                else {
                    s1++;
                }
            }
            if (s1 == e1) return s;
            s++;
        }
        return -1;
    }
    /*if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int h = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= h-n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }

            if(j == n)
                return i;
        }
        return -1;*/

    public static void main(String a[]) {
        Strstr st = new Strstr();
        System.out.println(st.strStr("InterviewBitAwesome", "Bit"));
    }
}
