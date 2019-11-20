package Java;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 16-07-2017.
 */
public class VLA2 implements Comparator<VLA2> {

    static int err() throws Exception {

        try {
            throw new IOException("..");
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            return - 1;
        }
    }

    int dishSize;
    VLA2(int dishSize) {
        this.dishSize = dishSize;
    }

    @Override
    public int compare(VLA2 o1, VLA2 o2) {
        return o2.dishSize - o1.dishSize;
    }


    static String decode(String encodedText) {

        Map<String, Character> symbolByEncoding = new HashMap<>();
        symbolByEncoding.put("011001", 'C');
        symbolByEncoding.put("110111", 'a');

        StringBuilder originalText =  new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < encodedText.length(); i++) {
            sb.append(encodedText.charAt(i));
            if (symbolByEncoding.containsKey(sb.toString())) {
                if (sb.toString().equals("010100")) {
                    System.out.println();
                    sb = new StringBuilder();
                    //originalText.append("\n");
                    continue;
                }
                System.out.print(symbolByEncoding.get(sb.toString()));
                originalText.append(symbolByEncoding.get(sb.toString()));
                sb = new StringBuilder();
            }
        }
        return originalText.toString();
        //Character temp = symbolByEncoding.get(sb.toString());
    }


    public static void main(String a[]) throws Exception {

        VLA2.decode("01100111011110111110110");
        //System.out.print(VLA2.err());
        /*VLA2[] vla2s = {new VLA2(40), new VLA2(200),new VLA2(60)};
        Arrays.sort(vla2s, vla2s[0]);
        int index = Arrays.binarySearch(vla2s, new VLA2(40), vla2s[0]);
        System.out.println(index + " ");
        index = Arrays.binarySearch(vla2s, new VLA2(80), vla2s[0]);
        System.out.println(index);*/
    }
}
