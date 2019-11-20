package DataStructures.arrays;

import java.util.ArrayList;

/**
 * Created by senthil on 20/8/16.
 */
public class PascalsTriangle {

    /*public List<Integer> getRow(int rowIndex) {

        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }*/

    public ArrayList<ArrayList<Integer>> buildPascal(int n) {

        ArrayList<ArrayList<Integer>> pList = new ArrayList<>();

        if(n == 0) return pList;

        ArrayList<Integer> p = new ArrayList<>();
        p.add(1);
        pList.add(p);

        for(int i = 1; i <= n; i++) {

            ArrayList<Integer> c = new ArrayList<>();
            c.add(1);
            for(int j = 0; j < i - 1; j++) {
                c.add(p.get(j) + p.get(j+1));
            }
            c.add(1);

            pList.add(c);

            p = c;
        }
        return pList;
    }

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> p = new ArrayList<>();

        if (a == 0) {
            p.add(1);
            return p;
        }
        p.add(1);

        for (int i = 1; i <= a; i++) {
            ArrayList<Integer> c = new ArrayList<>();

            c.add(1);

            for (int j = 0; j < i - 1; j++) {
                c.add(p.get(j) + p.get(j + 1));
            }
            c.add(1);
            p = c;

            if (a == i-1) return c;
        }
        return p;
    }

    public static void main(String a[]) {
        PascalsTriangle pt = new PascalsTriangle();
        //pt.buildPascal(4);
        pt.getRow(4);
    }
}
