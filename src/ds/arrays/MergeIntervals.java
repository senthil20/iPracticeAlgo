package ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by senthil on 12/8/16.
 */

class Interval {
    int s;
    int e;

    Interval(int s, int e) {
        this.s = s;
        this.e = e;
    }
}
public class MergeIntervals {

    public ArrayList<Interval> mergeInterval(ArrayList<Interval> list) {

        ArrayList<Interval> retList = new ArrayList<>();

        if(list == null || list.size() == 0) return retList;

        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                 return Integer.compare(i1.s, i2.s);
            }
        });

        Interval prev = list.get(0);

        for(int i=1; i < list.size(); i++) {
            Interval curr = list.get(i);

            if(curr.s > prev.e) {
                retList.add(prev);
                prev = curr;
            }
            else {
                prev = new Interval(prev.s, Math.max(prev.e, curr.e));
            }
        }
        retList.add(prev);

        return retList;
    }

    public static void main(String ar[]) {
        MergeIntervals m = new MergeIntervals();
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1,5));
        list.add(new Interval(2,3));
        //list.add(new Interval(8,10));
        //list.add(new Interval(11,18));
        //o/p #1,6 #8,10 #15,18  is not needed
        System.out.print(m.mergeInterval(list));
    }
}
