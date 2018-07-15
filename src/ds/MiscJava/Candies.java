package ds.MiscJava;

public class Candies {
    static int total = 0;
    public static int countCandies(int startingAmount, int newEvery) {
        //int[] dp = new int[startingAmount + 1];

        /*if (startingAmount < newEvery) {
            total += 1;
            return total;
        };
        total += newEvery;
        int remaining  = startingAmount - newEvery  + 1;
        countCandies(remaining, newEvery);
        return total;*/

        int val = 1;
        int count = 0;
        for (int i = 1; i < startingAmount && count < startingAmount; i++) {
            val += newEvery;
            count += i;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(Candies.countCandies(10, 2));
    }
}