package ds.MiscJava;

public class StringPermutation {

    public void perm(String prefix, String str) {
        if (str.length() == 0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            perm(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }

    public void caps(String str) {


    }

    public static void main(String a[]) {
        StringPermutation sp = new StringPermutation();
        //sp.perm("", "abc");
        sp.caps("0ab");
    }
}
