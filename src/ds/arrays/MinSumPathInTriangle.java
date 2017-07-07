package ds.arrays;

import java.util.ArrayList;

public class MinSumPathInTriangle {

    int sum = 0;
    int minSum = Integer.MAX_VALUE;

    public int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        return minPath(input, 0, input.size() - 1, 0);
    }

    public int minPath(ArrayList<ArrayList<Integer>> input, int row, int max, int index) {

        if (row > max || index > row) return -1;

        ArrayList<Integer> data = input.get(row);
        if (row == max) {
            return data.get(index);
        }

        if (row > input.size() - 1 || index > input.get(row).size()) {
            minSum = Math.min(minSum, sum);
            return minSum;
        }

        int left = minPath(input, row + 1, max, index);
        int right = minPath(input, row + 1, max, index + 1);
        return data.get(index) + Math.min(left, right);
    }

    /**
                1
             3     2
           6    5    4
         7   1   9    8
     */
    public static int minTriangleDepth1(ArrayList<ArrayList<Integer>> input) {
        int minSum = 0, rowSize = 0, index = 0, prev = 0, next = 0;
        if(input.size() == 0) return minSum;
        minSum = input.get(0).get(0);
        index = 0;
        for (int i = 1;i < input.size();i++) {
            prev = index;
            next = index + 1;
            if (input.get(i).get(prev) <= input.get(i).get(next)) {
                minSum += input.get(i).get(prev);
                index = prev;
            } else if (input.get(i).get(prev) > input.get(i).get(next)) {
                minSum += input.get(i).get(next);
                index = next;
            }
        }
        return minSum;
    }

    public static void main(String a[]) {
        MinSumPathInTriangle mpath = new MinSumPathInTriangle();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(1);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        list3.add(1);
        input.add(list0);
        input.add(list1);
        input.add(list2);
        input.add(list3);

        System.out.println(mpath.minTriangleDepth1(input));
    }
}
