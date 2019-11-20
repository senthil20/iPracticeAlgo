package DataStructures.arrays;

public class QuickSort {

    int a[];

    QuickSort(int[] a) {
        this.a = a;
    }

    private void quickSort() {
        qSort(a, 0, a.length-1);
    }

    private void qSort(int[] a, int start, int end) {
        if(start < end) {
            int partitionIndex = partitionIndex(a, start, end);
            qSort(a, start, partitionIndex-1);
            qSort(a, partitionIndex+1, end);

        }
    }

    private int partitionIndex(int a[], int s, int end) {

        int pIndex = s;
        int pivot = a[end];

        for(int i=s; i<end; i++) {

            if(a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }
        swap(a, pIndex,end);
        return pIndex;
    }

    private void swap(int a[], int s, int d) {
        int temp = a[s];
        a[s] = a[d];
        a[d] = temp;
    }

    public static void main(String[] args) {
        int a[] = {9, 6, 5, 1, 3, 10, 12};
        QuickSort qs = new QuickSort(a);
        qs.quickSort();
        System.out.println(a);

    }
}
