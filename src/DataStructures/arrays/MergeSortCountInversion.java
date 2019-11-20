package DataStructures.arrays;

public class MergeSortCountInversion {
    static int totalInversion = 0;

    static long countInversions(int[] arr) {
        int n = arr.length;
        if (n < 2) return 0;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < n; j++) {
            right[j - mid] = arr[j];
        }
        countInversions(left);
        countInversions(right);
        merge(arr, left, right);
        return totalInversion;
    }

    public static void merge(int a[], int l[], int r[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l.length && j < r.length) {
            if(l[i] <= r[j]) {
                a[k] = l[i];
                i++;
            }
            else {
                a[k] = r[j];
                j++;
                totalInversion += (l.length) - i;
            }
            k++;
        }
        while(i < l.length) {
            a[k++] = l[i++];
        }
        while(j < r.length) {
            a[k++] = r[j++];
        }
    }

    public static void main(String a[]) {
        int A[] = new int[]{7, 5, 3, 1};
        countInversions(A);
        System.out.println(totalInversion);
    }
}
