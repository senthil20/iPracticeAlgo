package DataStructures.arrays;

import java.util.ArrayList;

/**
 * Created by senthil on 21/8/16.
 */
public class AntiDiagonals {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
            }
            res.add(row);
        }
        return res;
    }


    public static void main(String ar[]) {
        AntiDiagonals ad = new AntiDiagonals();

        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list.add(1);list.add(2);list.add(3);
        list1.add(4);list1.add(5);list1.add(6);
        list2.add(7);list2.add(8);list2.add(9);

        l1.add(list);
        l1.add(list1);
        l1.add(list2);

        ad.diagonal(l1);
    }
}