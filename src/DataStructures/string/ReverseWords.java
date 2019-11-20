package DataStructures.string;

public class ReverseWords {

    public String reverseWords(String str) {
        if(str == null || str.length() < 2) return str;

        str = str.trim();

        char c[] = str.toCharArray();

        int s = 0;
        int e = c.length - 1;

        reverseChars(c, s, e);

        s = 0; e = c.length - 1;
        int t = 0;

        while(s < e) {
            if(c[s] == ' ' && c[s+1] != ' ') {
                reverseChars(c, t, s-1);
                t = s + 1;
            }
            s++;
        }

        reverseChars(c, t, e);

        return new String(c);
    }

    public void reverseChars(char c[], int s, int e) {
        while(s < e) {
            if(c[s] == ' ' && c[s+1] == ' ') {
                s++;
                continue;
            }
            swap(c, s, e);
            s++;
            e--;
        }
    }

    public String reverseWords1(String a) {

        if(a == null || a.length() == 0) return a;

        String[] str = a.split(" ");

        StringBuffer sb = new StringBuffer();

        for(int i = str.length - 1 ; i >= 0; --i) {
            if (!str[i].equals(""))
                sb.append(str[i]).append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public void swap(char[] c, int s, int d) {
        char t = c[s];
        c[s] = c[d];
        c[d] = t;
    }


    public static void main(String a[]) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords1(" "));
    }
}
