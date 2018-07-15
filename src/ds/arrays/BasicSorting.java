package ds.arrays;

public class BasicSorting {
    //5,3,1,4,6,0
    static int[] insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j > 0 && A[j - 1] > A[j]) {
                int t = A[j - 1];
                A[j - 1] = A[j];
                A[j] = t;
                j--;
            }
        }
        return A;
    }

    static void insertSort(int A[]) {
        int n = A.length;
        for (int i=1; i<n; ++i)
        {
            int key = A[i];
            int j = i-1;


            while (j>=0 && A[j] > key)
            {
                A[j+1] = A[j];
                j = j-1;
            }
            A[j+1] = key;
        }
        System.out.println(A);
    }

    static int[] bucketSort(int[] A, int max)
    {
        int[] bucket = new int[max + 1];
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++)
            bucket[A[i]]++;

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                result[outPos++] = i;

        return result;
    }

    public static void bubbleSort(int[] a) {
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
        int NUM_THREADS = Runtime.getRuntime().availableProcessors();
        System.out.println(NUM_THREADS);
        int a[] = new int[] {3,2,1};
        bubbleSort(a);
        System.out.print(a);
        insertSort(new int[]{5,3,1,4,6,0});
        int[] result = bucketSort(new int[]{1, 2, 2, 90, 100, 5, 200, 400, 6, 7, 12, 15, 900}, 900);
        System.out.println(result);
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