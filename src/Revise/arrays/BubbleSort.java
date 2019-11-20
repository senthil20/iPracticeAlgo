package Revise.arrays;

public class BubbleSort {

    public static void bubbleSort(int A[]) {
        int n = A.length;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (A[j - 1] > A[j]) {
                    int temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                }
             }
        }
    }

    public static void main(String a[]) {
        int[] A = new int[]{5, 2, 6, 1, 3, 7, 4};
        bubbleSort(A);
        System.out.println(A);
    }
}
