package DataStructures.string;

/**
 * Created by User on 09-07-2017.
 */
public class PossibleDecodingOfDigitalSeq {

    static long countPossibleDecodings(int[] array, int n)
    {
        if (n == 0 || n == 1)
            return 1;
        long count = 0;
        if (array[n - 1] > 0)
            count =  countPossibleDecodings(array, n-1);
        if (array[n - 2] == 1 || (array[n - 2] == 2 && array[n - 1] < 7) )
            count += countPossibleDecodings(array, n - 2);
        return count;
    }

    public static void main(String a[]) {
        System.out.println(PossibleDecodingOfDigitalSeq.countPossibleDecodings(new int[]{1, 2, 2, 3}, 4));
    }
}
