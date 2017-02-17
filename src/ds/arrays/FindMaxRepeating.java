package ds.arrays;

public class FindMaxRepeating {


    public int findMaxRepeating(int[] arr) {
        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        int k = arr.length;
        for (int i = 0; i< arr.length; i++)
            arr[(arr[i]%k)] += k;

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }
        /* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        // Return index of the maximum element
        return result;
    }
    public static int getMaxRepetition(int[] a) {
        int k = a.length;
        for (int i = 0; i < a.length; i++)
            a[a[i] % k] += k;
        int max = a[0];
        int val = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                val = i;
            }
        }
        return val;
    }


    public static void main(String a[]) {
        FindMaxRepeating fm = new FindMaxRepeating();
        fm.findMaxRepeating(new int[]{1, 2, 1, 2, 3, 2});
    }
}
