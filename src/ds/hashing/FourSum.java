package ds.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (a == null || a.size() == 0) return result;

        Collections.sort(a);

        ArrayList<Integer> list = new ArrayList<>();
        Set<ArrayList<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < a.size() - 3; i++) {

            if (i != 0 && a.get(i) == a.get(i - 1)) continue;

            for (int j = i + 1; j < a.size() - 2; j++) {

                if (j != i + 1 && a.get(j) == a.get(j - 1)) continue;

                int s = j + 1;
                int e = a.size() - 1;

                while (s < e) {

                    int val = a.get(i) + a.get(j) + a.get(s) + a.get(e);

                    if (val > b) e--;

                    else if (val < b) s++;

                    else {
                        list.add(a.get(i));
                        list.add(a.get(j));
                        list.add(a.get(s++));
                        list.add(a.get(e--));

                        if (!set.contains(list)) {
                            set.add(list);
                        }
                        //Collections.sort(list);

                        list = new ArrayList<>();
                    }
                }
            }
        }
        result = new ArrayList<>(set);
        return result;
    }
    public static void main(String a[]) {

    }
}


