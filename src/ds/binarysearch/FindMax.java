package ds.binarysearch;

/**
 * Created by senthil on 1/9/16.
 */
public class FindMax {

    /**
     * array is increasing and then decreasing find max in it
     * 5, 12, 15, 4, 3, 2 ,1
     * 4, 5, 6, 7, 2, 1 ,0
     * @param a
     * @return
     */
    public int findmax(int a[]) {

        if (a == null || a.length == 0) return -1;

        int s = 0;
        int e = a.length - 1;

        while (s <= e) {
            int mid = s + (e-s)/2;

            if (mid > 0 && a[mid] < a[mid -1])
                e = mid - 1;
            else if (mid < a.length - 1 && a[mid] < a[mid + 1]) {
                s = mid + 1;
            }
            else
                return a[mid];
        }
        return -1;
    }

    public int findMin(int a[]) {
        if (a == null || a.length == 0) return -1;

        int s = 0;
        int e = a.length - 1;

        while (s <= e) {
            if (e - s == 1) return a[e];

            int mid = s + (e-s)/2;

            if (a[e] > a[mid])
                e = mid;
            else if (a[e] < a[mid]) {
                s = mid;
            }
            else
                return a[s];
        }
        return -1;
    }

    public int findMin1(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            if(nums[i]<=nums[j])
                return nums[i];

            int m=(i+j)/2;

            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return -1;
    }

    public static void main(String a[]) {
        //System.out.println(new FindMax().findmax(new int[]{7,8,9,10}));
        System.out.println(new FindMax().findMin1(new int[]{11, 12, 15, 20, 21, 0, 1, 7, 9}));
    }
}
