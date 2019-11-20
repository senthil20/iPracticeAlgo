package DataStructures.arrays;

public class MergeArrays {

    private void merge(int A[], int B[]) {
        int i = 0;
        int j = 0;
        int Al = A.length;
        int Bl = B.length;

        while(i < Al && j < Bl) {
            if(A[i] <= B[j]) {
                i++;
            }
            else if(A[i] >= B[j]) {
                System.arraycopy(A, i, A, i+1, Al-(i+1));
                A[i] = B[j];
                i++;
                j++;
            }

        }
        while(i < Al && j < Bl) {
            A[i] = B[j];
            i++;
            j++;
        }
        System.out.println(A);
    }

    public static void main(String[] args) {
        MergeArrays m = new MergeArrays();
        int A[] = {2, 4, 6, 7, 9, 12, 0, 0, 0, 0, 0};
        int B[] = {1, 3, 10};
        m.merge(A, B);
    }
}
