package ds.twopointers;

import java.util.*;

public class FourSum {

    //I/p : [1,0,-1,0,-2,2], 0
    //O/p : [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    /**
     Input:
     [1,0,-1,0,-2,2]
     0
     Output:
     [[-2,0,0,2],[-2,-1,0,2],[-1,0,0,1]]
     Expected:
     [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
               if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int s = j + 1;
                int e = nums.length - 1;

                while (s < e) {
                    int val = nums[i] + nums[j] + nums[s] + nums[e];

                    if (val == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[s++]);
                        list.add(nums[e--]);
                        set.add(list);
                        list = new ArrayList<>();
                    }
                    else if (val > target) {
                        e--;
                    }
                    else s++;
                }
            }
        }
        result = new ArrayList<>(set);
        return result;
    }

    //four sum using hashing
    public List<List<Integer>> fourSum1(int[] a, int b) {

        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length == 0) return result;
        Map<Integer, List<List<Integer>>> auxMap = new HashMap<>();
        Set<List<Integer>> set = new LinkedHashSet<>();

        //fill the hashMap
        for (int i = 0; i < a.length - 1; i++) {
            for(int j = i + 1; j < a.length; j++) {
                int val = a[i] + a[j];
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                if (!auxMap.containsKey(val)) {
                    List<List<Integer>> origList = new ArrayList<>();
                    origList.add(list);
                    auxMap.put(val, origList);
                }
                else {
                    List<List<Integer>> origList = auxMap.get(val);
                    origList.add(list);
                }
            }
        }

        for (Integer val : auxMap.keySet()) {

            if (auxMap.containsKey(b - val)) {
                List<List<Integer>> list = auxMap.get(val);
                /*if (b - val == val && list.size() == 1)
                    continue;*/
                List<List<Integer>> list1 = auxMap.get(b - val);

                for (List<Integer> pair1 : list) {
                    for (List<Integer> pair2 : list1) {
                        if (pair1 == pair2) continue;

                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;

                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[pair1.get(0)]);
                        temp.add(a[pair1.get(1)]);
                        temp.add(a[pair2.get(0)]);
                        temp.add(a[pair2.get(1)]);
                        Collections.sort(temp);
                        if (!set.contains(temp)) {
                            set.add(temp);
                        }
                    }
                }
            }
        }
        result = new ArrayList<>(set);
        return result;
    }

    public List<List<Integer>> fourSum2(int[] num, int target) {
        //Create the dictionary.
        HashMap<Integer, ArrayList<ArrayList<Integer>>> dict = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                ArrayList<Integer> pair = new ArrayList<>(2);
                pair.add(i);
                pair.add(j);
                if (!dict.containsKey(sum)) {
                    ArrayList<ArrayList<Integer>> value = new ArrayList<>();
                    value.add(pair);
                    dict.put(sum, value);
                } else {
                    ArrayList<ArrayList<Integer>> value = dict.get(sum);
                    value.add(pair);
                }
            }
        }
        //Use HashSet to prevent duplicate result.
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for (Integer sum : dict.keySet()) {
            ArrayList<ArrayList<Integer>> sumPair = dict.get(sum);
            if (dict.containsKey(target - sum)) {
                if (target - sum == sum && sumPair.size() == 1)
                    continue;
                ArrayList<ArrayList<Integer>> pairs = dict.get(target - sum);
                for (ArrayList<Integer> pair1 : sumPair) {
                    for (ArrayList<Integer> pair2 : pairs) {
                        //Make sure it is not the same pair.
                        if (pair1 == pair2)
                            continue;
                        //Make sure there is no same element in two pairs.
                        if (pair1.contains(pair2.get(0)) || pair1.contains(pair2.get(1)))
                            continue;
                        ArrayList<Integer> tmpResult = new ArrayList<>(4);
                        tmpResult.add(num[pair1.get(0)]);
                        tmpResult.add(num[pair1.get(1)]);
                        tmpResult.add(num[pair2.get(0)]);
                        tmpResult.add(num[pair2.get(1)]);
                        //Sort the list and add it into the set.
                        Collections.sort(tmpResult);
                        set.add(tmpResult);
                    }
                }
            }
        }
        List<List<Integer>> ret = new LinkedList<>();
        ret.addAll(set);
        return ret;
    }


    public static void main(String a[]) {
        FourSum fs = new FourSum();
        fs.fourSum1(new int[]{1,0,-1,0,-2,2}, 0);
    }
}
