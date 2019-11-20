package DataStructures.string;

public class ValidNumber {


    public int validNumber(String str) {
        if (str == null || str.length() == 0) return 0;
        String str1 = str.trim();
        boolean num = false;
        boolean exp = false;
        boolean dot = false;

        int s = 0;
        int e = str1.length() - 1;

        while (s <= e) {
            char c = str1.charAt(s);

            if (Character.isDigit(c)) num = true;
            else if (c == '.') {
                if(dot || exp || str1.charAt(e) == '.') return 0;
                dot = true;
                num = false;
            }
            else if (c == 'e' || c == 'E') {
                if(exp || !num) return 0;
                exp = true;
                num = false;
            }
            else if (c == '+' || c == '-') {
                if (s > 0 && str1.charAt(s-1) != 'e') return 0;
            }
            else return 0;
            s++;
        }
        return num ? 1 : 0;
    } /*{

        if (str == null || str.length() == 0) return false;

        str = str.trim();

        boolean num = false;
        boolean dot = false;
        boolean exp = false;

        int s = 0;
        int e = str.length()-1;

        while (s <= e) {
            char c = str.charAt(s);

            if(Character.isDigit(c)) num = true;

            else if(c == '.') {
                if(dot || exp) return false;
                dot = true;
            }
            else if(c == 'e' || c == 'E') {
                if(exp || !num) return false;
                exp = true;
                num = false;
            }
            else if(c == '+' || c == '-') {
                if(s > 0 && str.charAt(s-1) != 'e') return false;
            }
            else
                return false;
            s++;
        }
        return num;
    }*/


    public static void main(String a[]) {
        ValidNumber vn = new ValidNumber();
        // "." , "1."  true,  "1.e2" true, ".3" true.
        // " e ", ".e1" false,  "1e.1" false, "1e1.1" false, "2.3e" false.
        // "+/-", "+1.e+5" true.
        //Some examples:
        //"0" => true " 0.1 " => true "abc" => false "1 a" => false "2e10" => true
        System.out.println(vn.validNumber("1.e1"));
    }
}
