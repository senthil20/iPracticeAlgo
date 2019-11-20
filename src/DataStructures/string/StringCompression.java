package DataStructures.string;

/**
 * Created by sydgsk9 on 1/13/2017.
 */
public class StringCompression {
    public static String compressString(String text) {

        if (text == null || text.length() == 0) return text;
        int count = 1;
        StringBuffer result = new StringBuffer();
        int i = 1;
        for (; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(i - 1)) count++;
            else {
                result.append(text.charAt(i - 1)).append(count > 1 ? count : "");
                count = 1;
            }
        }
        result.append(text.charAt(i - 1)).append(count > 1 ? count : "");
        return result.toString();
    }

    public static void main(String a[]) {
        System.out.println(StringCompression.compressString("abccdddbb"));
    }
}
