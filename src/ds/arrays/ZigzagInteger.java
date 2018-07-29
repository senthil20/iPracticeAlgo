package ds.arrays;

/**
 *
 */
public class ZigzagInteger {

    public static int zigzag(int[] A) {
        if (A == null || A.length == 0) return 0;
        int max = 0;
        int s = 1;
        int e = A.length;
        int index = 0;
        while (s < e) {
            if ((s > 0 && A[s] < A[s - 1] && s < A.length - 1 && A[s] < A[s + 1])
                    || (s > 0 && A[s] > A[s - 1] && s < A.length - 1 && A[s] > A[s + 1])) {
                max = Math.max(max, (s + 1) - index + 1);
                s = s + 2;
                continue;
            }
            if (s == A.length - 1) {
                if (A.length > 1) {
                    if ((A[s] < A[s - 1] && A[s] >= A[s - 2]) ||
                            (A[s] > A[s - 1]) && A[s] <= A[s - 2]) {
                        max = Math.max(max, (s - index + 1));
                    }
                }
                s++;
            }
            else {
                index = s;
                s++;
            }
        }
        return max;
    }

    public static void main(String a[]) {
        //int A[] = new int[]{4, 2, 3, 1, 5, 3};
        //int A[] = new int[]{9, 8, 8, 5, 3, 5, 3, 2, 8, 6};
        //int A[] = new int[]{9, 8, 8, 5, 3, 5, 3};
        int A[] = new int[]{4, 4};
        int result =zigzag(A);
        System.out.println(result);
    }
}
