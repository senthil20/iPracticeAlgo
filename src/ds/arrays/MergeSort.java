package ds.arrays;

/**
 * Created by senthil on 12/8/16.
 */
public class MergeSort {

    public void mergeSort(int a[]) {
        int n = a.length;
        if (n < 2) return;
        int mid = n/2;

        int[] l = new int[mid];
        int[] r = new int[n-mid];

        for(int i = 0; i < mid; i++)
            l[i] = a[i];
        for(int j = mid; j < n; j++)
            r[j-mid] = a[j];

        mergeSort(l);
        mergeSort(r);
        merge(a, l, r);
    }

    public void merge(int a[], int l[], int r[]) {
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

    public static void main(String ar[]) {
        MergeSort ms = new MergeSort();
        int a[] = new int[]{2,4,1,3,8,0};
        ms.mergeSort(a);
        System.out.println(a);
    }
}
