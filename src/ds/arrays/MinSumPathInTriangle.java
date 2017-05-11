package ds.arrays;

import java.util.ArrayList;

//INCOMPLETE
public class MinSumPathInTriangle {

    int sum = 0;
    int minSum = Integer.MAX_VALUE;

    public int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
        return minPath(input, 0, 0, 0);
    }

    public int minPath(ArrayList<ArrayList<Integer>> input, int row, int prevIndex, int currentIndex) {
        if (currentIndex - prevIndex > 1) return minSum;
        if (row > input.size() - 1 || currentIndex > input.get(row).size()) {
            minSum = Math.min(minSum, sum);
            return minSum;
        }
        sum += input.get(row).get(currentIndex);
        minPath(input, row + 1, prevIndex, currentIndex);
        sum -= input.get(row).get(currentIndex);
        minPath(input, row, currentIndex, currentIndex + 1);
        return minSum;
    }

    public static void main(String a[]) {
        MinSumPathInTriangle mpath = new MinSumPathInTriangle();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(1);
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        list3.add(10);
        input.add(list0);
        input.add(list1);
        input.add(list2);
        input.add(list3);

        System.out.println(mpath.minTriangleDepth(input));
    }
}
