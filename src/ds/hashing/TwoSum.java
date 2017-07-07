package ds.hashing;

import java.util.*;

/**
 * Examples:
    Input  :  arr[] = {1, 5, 7, -1},
    sum = 6
    Output :  2
    Pairs with sum 6 are (1, 5) and (7, -1)

    Input  :  arr[] = {1, 5, 7, -1, 5},
    sum = 6
    Output :  3
    Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)

    Input  :  arr[] = {1, 1, 1, 1},
    sum = 2
    Output :  6
    There are 3! pairs with sum 2.

    Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1},
    sum = 11
    Output :  9
 */

public class TwoSum {

    int countPairsWithDiffK(int numbers[], int k)
    {
        int count = 0;
        Set<Integer> set = new TreeSet<>();
        for (int val : numbers) set.add(val);
        for (int val : numbers) {
            int diff = val - k;
            if (set.contains(diff)) {
                count++;
            }
        }

        /*Arrays.sort(numbers);
        int n = numbers.length;
        int l = 0;
        int r = 0;
        while(r < n)
        {
            if(numbers[r] - numbers[l] == k)
            {
                count++;
                l++;
                r++;
            }
            else if(numbers[r] - numbers[l] > k)
                l++;
            else
                r++;
        }*/
        return count;
    }

    public int countPairs(int numbers[], int k) {
        int count = 0;
        Set<Integer> set = new TreeSet<>();
        for (int val : numbers) set.add(val);

        List<int[]> result = new ArrayList<>();
        List<int[]> tempList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i] - k;
            if (set.contains(val)) {
                int[] temp = new int[2];
                temp[0] = val;
                temp[1] = numbers[i];

                if (result.size() == 0) {
                    result.add(temp);
                    continue;
                }

                for (int[] arr : result) {
                    if ((arr[0] == temp[0] && arr[1] == temp[1])
                            || (arr[0] == temp[1] && arr[1] == temp[0])) {
                        temp = null;
                    }
                }
                if (temp != null) tempList.add(temp);
                result.addAll(tempList);
                tempList = new ArrayList<>();
            }
            else {
                set.add(numbers[i]);
            }
        }
        return result.size();
    }

    public List<Integer> twoSum(int a[], int b) {

        if (a == null || a.length == 0) return null;
        Map <Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int val = b - a[i];
            if (map.containsKey(val)) {
                list.add(a[i]);
                list.add(val);
            }
            else {
                map.put(a[i], i);
            }
        }
        return list;
    }

    //{12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9)
    //{1, 4, 45, 6, 10, 8} and given sum is 22, then there is a triplet (4, 8 and 10)
    public List<List<Integer>> threeSum(int[] a, int b) {

        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length == 0) return result;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(a);

        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i-1]) continue;
            int s = i + 1;
            int e = a.length - 1;
            while (s < e) {
                int val = a[i] + a[s] + a[e];
                if (val == b) {
                    list.add(a[i]);
                    list.add(a[s++]);
                    list.add(a[e--]);
                    result.add(list);
                    list = new ArrayList<>();
                }
                else if (val < b) {
                    s++;
                }
                else {
                    e--;
                }
            }
        }
        return result;
    }

    //For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23,
    // then your function should print “3 5 7 8″ (3 + 5 + 7 + 8 = 23).
    public void fourSum(int[] a, int sum) {

    }



    public static void main(String a[]) {
        TwoSum sum = new TwoSum();
        //sum.twoSum(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 9);
        //sum.threeSum(new int[]{12, 3, 4, 1, 6, 9}, 24);
        System.out.print(sum.countPairsWithDiffK(new int[]{2,4,6,8,10,12}, 2));
    }
}
