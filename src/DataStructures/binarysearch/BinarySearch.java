package DataStructures.binarysearch;

import java.math.BigInteger;
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


    private static boolean sortedRotatedArraySearch(int a[], int key) {

        if(a == null || a.length == 0) return false;

        int s = 0;
        int e = a.length - 1;

        while(s <= e) {
            int mid = (s+e)/2;

            if(a[mid] == key) return true;
            //second half is sorted
            else if(a[e] > a[mid]) {
                if(key > a[mid] && key <= a[e]) {
                    s = mid + 1;
                }
                else
                    e = mid - 1;
            }
            //first half
            else {
                if(key >= a[s] && key < a[mid]) {
                    e = mid - 1;
                }
                else
                    s = mid + 1;
            }
        }
        return false;
    }

    private static int sortedRotatedArrayMin(int a[]) {

        if(a == null || a.length == 0) return -1;

        int s = 0;
        int e = a.length - 1;
        int min = Integer.MAX_VALUE;

        while(s <= e) {
            int mid = (s+e)/2;

            if(a[mid] <= a[e]) {
                e = mid - 1;
                min = Math.min(min, a[mid]);
            }
            else {
                s = mid + 1;
                min = Math.min(min, a[s]);
            }

        }
        return min;
    }


    public static int pow(int x, int n, int d) {

        boolean isNeg = false;
        BigInteger result = new BigInteger("1");
        BigInteger x1 = BigInteger.valueOf(x);

        if(n < 0) {
            n = -n;
            isNeg = true;
        }

        while(n != 0) {
            if(n%2 != 0) {
                result = result.multiply(x1).mod(BigInteger.valueOf(d));
            }
            x1 = x1.multiply(x1).mod(BigInteger.valueOf(d));
            n = n/2;
        }

        if(isNeg) result = BigInteger.valueOf(1).divide(result);
        if(result.intValue() < 0)
            return (result.add(BigInteger.valueOf(d))).mod(BigInteger.valueOf(d)).intValue();
        else
            return result.mod(BigInteger.valueOf(d)).intValue() ;
    }


    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;
        //int aMid = (aStart+aEnd)/2;
        //int bMid = (bStart+bEnd)/2;
        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }

   /* public double findMedianSortedArrays(int A[], int B[]) {
        int lengthA = A.length;
        int lengthB = B.length;
        if ((lengthA + lengthB) % 2 == 0) {
            double r1 = (double) findMedianSortedArrays(A, 0, lengthA-1, B, 0, lengthB-1, (lengthA + lengthB) / 2);
            double r2 = (double) findMedianSortedArrays(A, 0, lengthA-1, B, 0, lengthB-1, (lengthA + lengthB) / 2 + 1);
            return (r1 + r2) / 2;
        } else
            return findMedianSortedArrays(A, 0, lengthA-1, B, 0, lengthB-1, (lengthA + lengthB) / 2);
    }

    public int findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        int n = endA - startA;
        int m = endB - startB;

        if (n <= 0)
            return B[startB + k - 1];
        if (m <= 0)
            return A[startA + k - 1];
        if (k == 1)
            return A[startA] < B[startB] ? A[startA] : B[startB];

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if (A[midA] <= B[midB]) {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, endA, B, startB, midB, k);
            else
                return findMedianSortedArrays(A, midA + 1, endA, B, startB, endB, k - n / 2 - 1);
        } else {
            if (n / 2 + m / 2 + 1 >= k)
                return findMedianSortedArrays(A, startA, midA, B, startB, endB, k);
            else
                return findMedianSortedArrays(A, startA, endA, B, midB + 1, endB, k - m / 2 - 1);

        }
    }*/

    private int sum(int A[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += A[i];
        return total;
    }

    private int partition(int A[], int n, int k) {
        if (k == 1)
            return sum(A, 0, n-1);
        if (n == 1)
            return A[0];

        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            best = Math.min(best, Math.max(partition(A, j, k-1), sum(A, j, n-1)));
            System.out.println("current best " + best);
        }
        return best;
    }

    public static int pow2(int x, int n, int d) {
        long result = 1;
        long x1 = x;

        while(n > 0) {
            if(n%2 != 0) {
                result = (result * x1) % d;
            }
            x1 = (x1 * x1) % d;
            n = n/2;
        }
        if(result < 0)
            return (int)(result+d) % d;
        else
            return (int)result % d ;
    }




    public static void main(String s[]) {
        BinarySearch bs = new BinarySearch();
        //int a[] = new int[]{1,2,3,4,4,4,4,5,6};
        /*BinarySearch.binarySearch(a, 6);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        BinarySearch.searchRange1(list, 1);
        BinarySearch.findCount(list, 1);*/
        //int a[] = new int[]{186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74, 77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148, 150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185};
        //System.out.println(BinarySearch.sortedRotatedArraySearch(a, 143));
        //int a[] = new int[]{-1};
        //System.out.println(BinarySearch.sortedRotatedArrayMin(a));
        //System.out.println(BinarySearch.pow(71045970,41535484,64735492));
        //System.out.println(BinarySearch.pow(-1,1,20));
        //int a[] = new int[]{14};
        //int b[] = new int[]{1,2,3};
        //System.out.println(BinarySearch.findMedianSortedArrays(a, b));
        //System.out.println(bs.findMedianSortedArrays(a, b));
        //System.out.println(bs.partition(new int[]{10,20,40,5,20}, 5, 3));
        BinarySearch.pow2(71045970, 41535484, 64735492);

    }
}
