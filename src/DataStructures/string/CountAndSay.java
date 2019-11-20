package DataStructures.string;

/**
 * Created by senthil on 28/8/16.
 */
public class CountAndSay {

    public String countAndSay(int n) {

        if(n <= 0) return null;

        String prev = "1";

        int i = 1;
        int count = 0;
        StringBuffer sb = null;

        while(i < n) {

            sb = new StringBuffer();
            count = 1;

            for(int j = 1; j < prev.length(); j++) {
                if(prev.charAt(j-1) == prev.charAt(j)) {
                    count++;
                }
                else {
                    sb.append(count).append(prev.charAt(j-1));
                    count = 1;
                }
            }
            i++;
            prev = sb.append(count).append(prev.charAt(prev.length()-1)).toString();

        }
        return prev;
    }

    public static void main(String a[]) {
        CountAndSay cs = new CountAndSay();
        cs.countAndSay(6);
    }
}
