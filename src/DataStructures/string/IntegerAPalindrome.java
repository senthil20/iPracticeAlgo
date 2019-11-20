package DataStructures.string;

/**
 Write a method that checks if a given integer is a palindrome - without allocating additional heap space
 Examples:
 -1 ==> false
 0 ==> true
 1221 ==> true
 */
public class IntegerAPalindrome {

    public static int firstDigit(int n) {
        while (n < -9 || 9 < n) {
            n /= 10;
        }
        return Math.abs(n);
    }

    public static Boolean isIntPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        String str = String.valueOf(x);
        int s = 0;
        int e = str.length() - 1;
        while (s <= e) {
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            }
            else return false;
        }
        return true;
    }

    public static Boolean isIntPalindrome1(int x) {
        int num = x;
        //reversing number
        int reverse=0,remainder;
        while(num > 0)
        {
            remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }
        return (reverse == x);
    }

    public static Boolean isIntPalindrome2(int x) {
        int n = x;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev == x;
    }

    public static void main(String a[]) {
        //IntegerAPalindrome.firstDigit(89189);
       System.out.println(IntegerAPalindrome.isIntPalindrome2(5678));
    }
}
