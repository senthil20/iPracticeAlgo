package ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        return arr;
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
        bs.selectionSort(new int[]{5, 6, 7, 8, 1, 3, 9});
        //bs.digitSum(1234);
        //int a[] = {5,2,1,3,9,4,12,6};
        //bs.bubbleSort(a);
        //System.out.println(a);
        /*List<Pair> list = new ArrayList<>();
        list.add(new Pair(2, 3));
        list.add(new Pair(0, 13));
        list.add(new Pair(1, 31));
        list.add(new Pair(7, 4));
        list.add(new Pair(5, 2));
        list.add(new Pair(4, 7));
        bs.sortTest(list);*/
    }
}