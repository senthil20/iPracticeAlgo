package DataStructures.string;

/**
 * Created by senthil on 28/8/16.
 */
public class CompareVersionNumber {

    public int compareVersion(String a, String b) {

        int i = 0;
        int j = 0;


        String[] s = a.split("\\.");
        String[] s1 = b.split("\\.");

        //Long test = Long.valueOf("4444444444444444444");

        while (i < s.length && j < s1.length) {

            if (Long.valueOf(s[i]) == (Long.valueOf(s1[j]))) {
                i++;
                j++;
            }
            else if(Long.valueOf(s[i]) > (Long.valueOf(s1[j]))) {
                return 1;
            }
            else {
                return -1;
            }
        }

        if(i < s.length && Long.valueOf(s[s.length-1]) != 0) {
            return 1;
        }
        if(j < s1.length && Long.valueOf(s1[s1.length-1]) != 0) {
            return -1;
        }
        return 0;
    }

    public static void main(String a[]) {
        CompareVersionNumber vn = new CompareVersionNumber();
        //System.out.println(vn.compareVersion("444444444444444444444444", "4444444444444444444444444"));
        System.out.println(vn.compareVersion("1.0.2", "1.0.1"));
    }
}
