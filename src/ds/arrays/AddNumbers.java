package ds.arrays;

public class AddNumbers {

    public static int addNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String temp = String.valueOf(i);
            for (int j = 0; j < temp.length(); j++) {
                sum += Character.getNumericValue(temp.charAt(j));
            }
        }
        return sum;
    }

    public static int addNumbersDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String a[]) {
        System.out.println(AddNumbers.addNumbers(6));
        System.out.println(AddNumbers.addNumbersDP(6));
    }
}
