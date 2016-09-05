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

    public static void main(String[] args) {
        BasicSorting bs = new BasicSorting();
        int a[] = {5,2,1,3,9,4,12,6};
        bs.bubbleSort(a);
        System.out.println(a);
    }
}
