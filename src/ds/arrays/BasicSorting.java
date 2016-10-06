package ds.arrays;

/**
 * Created by senthil on 31/8/16.
 */
public class BasicSorting {

    public void bubbleSort(int[] a) {

        for(int i=0; i < a.length; i++) {
            for(int j=0; j < a.length-i-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    int digitSum(int n) {

        if (n == 0) return n;

        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
        //return recursiveSum(n, 0);
    }

    int recursiveSum(int n, int sum) {

        if (n == 0) return sum;

        sum += n % 10;

        return recursiveSum(n/10, sum);
    }

    public static void main(String[] args) {
        BasicSorting bs = new BasicSorting();
        bs.digitSum(1234);
        int a[] = {5,2,1,3,9,4,12,6};
        bs.bubbleSort(a);
        System.out.println(a);
    }
}
