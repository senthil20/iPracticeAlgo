package ds.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senthil on 1/7/16.
 */
public class BinarySearch {

    public static int findCount(final List<Integer> a, int b) {

        if(a == null || a.size() ==0) return 0;
        int n = a.size() - 1;

        int low = 0;
        int high = n;

        while(low < high) {
            int mid = low + (high-low)/2;

            if(b < a.get(mid)) {
                high = mid -1;
            }
            else if(b > a.get(mid)) {
                low = mid+1;
            }
            else {
                high = mid;
            }
        }
        if(high < low || a.get(low) != b) return 0;

        int first = low;
        high = n;

        while(low < high) {
            int middle = low + (high+1-low)/2;
            if (a.get(middle) > b) {
                high = middle-1;
            } else {
                low = middle;
            }
        }
        return (high - first) + 1;
    }

    public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(-1);

        if(a == null || a.size() == 0) return list;

        int s = 0;
        int n = a.size();
        int e = n-1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a.get(mid) == b)
                e = mid - 1;
            else if(a.get(mid) > b)
                e = mid - 1;
            else
                s = mid + 1;
        }
        if(s >=n || a.get(s) != b) return list;

        int first = s;
        e = n-1;

        while(s <= e) {
            int mid = (s+e)/2;
            if(a.get(mid) == b)
                s = mid + 1;
            else if(a.get(mid) > b)
                e = mid - 1;
        }

        list.set(0, first);
        list.set(1, e);
        return list;
    }


    public static boolean binarySearch(int a[], int b) {

        int s = 0;
        int n = a.length;
        int e = n;

        while(s < e) {
            int mid = (s+e)/2;
            if(a[mid] == b) {
                return true;
            }
            else if(a[mid] < b) {
                s = mid;
            }
            else
                e = mid;
        }
        return false;
    }


    //not o(logn)
    public static ArrayList<Integer> searchRange1(final List<Integer> a, int b) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(-1);

        if(a == null || a.size() == 0) return list;

        int index = a.indexOf(b);
        if(index < 0) return list;

        int l = index;
        int r = index;

        while(l > 0 && a.get(l-1) == b)
            l--;

        while(r < a.size()-1 && a.get(r+1) == b)
            r++;

        list.set(0, l);
        list.set(1, r);

        return list;
    }


    public static void main(String s[]) {
        int a[] = new int[]{1,2,3,4,4,4,4,5,6};
        BinarySearch.binarySearch(a, 6);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        BinarySearch.searchRange1(list, 1);
        BinarySearch.findCount(list, 1);
    }
}
