package ds.binarysearch;

public class BinarySearch {

    private static boolean binarySearch(int a[], int b) {
        if(a == null || a.length == 0) return false;
        int s = 0;
        int e = a.length-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == b) {
                return true;
            }
            else if(a[mid] < b) {
                s = mid + 1;
            }
            else
                e = mid-1;
        }
        return false;
    }

    private static int countOccurrence(int a[], int b) {
        if(a == null || a.length == 0) return -1;
        int n = a.length;
        int s = 0;
        int e = n - 1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == b) {
                e = mid - 1;
            }
            else if(a[mid] > b) {
                e = mid - 1;
            }
            else
                s = mid + 1;
        }
        if(s >= n || a[s] != b) return -1;
        int first = s;
        e = a.length-1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a[mid] == b) {
                s = mid + 1;
            }
            else if(a[mid] > b) {
                e = mid - 1;
            }
        }
        return e-first+1;
    }

    public static void main(String s[]) {
        /*int a[] = new int[]{1,2,3,5,7,9,10,11};
        System.out.println(BinarySearch.binarySearch(a, 4));*/
        int a[] = new int[]{-1,-1,0,1};
        System.out.println(BinarySearch.countOccurrence(a, -1));
    }

}
