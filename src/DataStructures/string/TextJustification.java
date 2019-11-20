package DataStructures.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senthil on 5/9/16.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> strList = new ArrayList<>();

        if (words == null || words.length == 0) return strList;
        int n = words.length;
        int len = 0;
        int index = 0;

        for (int i = 0; i < words.length; i++) {

            len += words[i].length();

            if (len + i - index > maxWidth) {

                int wordLen = len - words[i].length();
                int spaceReq = maxWidth - wordLen;

                int evenSpace = 1;
                int additionalSpace = 0;

                if (i - index - 1 > 0) {
                    evenSpace = spaceReq / (i - index - 1);
                    additionalSpace  = spaceReq % (i - index - 1);
                }

                StringBuffer sb = new StringBuffer();

                for (int j = index; j < i - 1; j++) {
                    sb.append(words[j]);
                    int t = 0;

                    while (t < evenSpace) {
                        sb.append(" ");
                        t++;
                    }

                    if (additionalSpace > 0) {
                        sb.append(" ");
                        additionalSpace--;
                    }
                }
                sb.append(words[i-1]);

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                strList.add(sb.toString());

                index = i;
                len = words[i].length();
            }

        }
        StringBuffer sb = new StringBuffer();

        //if every word fits within max width
        for (int k = index; k < n - 1; k++) {
            sb.append(words[k]).append(" ");
        }
        sb.append(words[n-1]);

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        strList.add(sb.toString());

        return strList;

    }


    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {

        ArrayList<String> strList = new ArrayList<>();

        if (a == null || a.size() == 0) return strList;

        int n = a.size();
        int len = 0;
        int index = 0;

        for (int i = 0; i < a.size(); i++) {

            len += a.get(i).length();

            if (len + i - index > b) {

                int wordLen = len - a.get(i).length();
                int spacesReq = b - wordLen;

                int evenSpace = 1;
                int additionalSpace = 0;

                if (i - index - 1 > 0) {
                    evenSpace = spacesReq / (i - index -1);
                    additionalSpace = spacesReq % (i - index -1);
                }

                StringBuffer sb = new StringBuffer();
                for (int j = index; j < i - 1; j++) {
                    sb.append(a.get(j));

                    int tmp = 0;
                    while (tmp < evenSpace) {
                        sb.append(" ");
                        tmp++;
                    }

                    if (additionalSpace > 0) {
                        sb.append(" ");
                        additionalSpace--;
                    }
                }
                // add last word
                sb.append(a.get(i-1));

                while (sb.length() < b) {
                    sb.append(" ");
                }

                strList.add(sb.toString());
                index = i;
                len = a.get(i).length();

            }
        }

        StringBuffer sb = new StringBuffer();

        for (int k = index; k < n - 1; k++) {
            sb.append(a.get(k)).append(" ");
        }

        sb.append(a.get(n-1));

        while (sb.length() < b) {
            sb.append(" ");
        }

        strList.add(sb.toString());

        return strList;
    }


    public static void main(String a[]) {

        TextJustification tj = new TextJustification();
        //tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "t", "ju"}, 16);
        ArrayList<String> list = new ArrayList<>();
        list.add("What");
        list.add("must");
        list.add("be");
        list.add("shall");
        list.add("be.");
        tj.fullJustify(list, 12);
    }
}
