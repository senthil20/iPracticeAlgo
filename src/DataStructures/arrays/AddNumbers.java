package DataStructures.arrays;

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

    public static void main(String a[]) {
        System.out.println(AddNumbers.addNumbers(13));
    }
}
