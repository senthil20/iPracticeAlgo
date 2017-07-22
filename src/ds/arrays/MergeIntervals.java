package ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

 Example 2:

 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 Make sure the returned intervals are also sorted.
 */

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}
public class MergeIntervals {

    public ArrayList<Interval> mergeInterval(ArrayList<Interval> list) {

        ArrayList<Interval> result = new ArrayList<>();
        if(list == null || list.size() == 0) return result;
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                 return Integer.compare(i1.start, i2.start);
            }
        });
        Interval prev = list.get(0);
        for(int i=1; i < list.size(); i++) {
            Interval curr = list.get(i);
            if(curr.start > prev.end) {
                result.add(prev);
                prev = curr;
            }
            else {
                prev = new Interval(prev.start, Math.max(prev.end, curr.end));
            }
        }
        result.add(prev);
        return result;
    }

    public static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
        ArrayList<Interval> result = new ArrayList<Interval>();

        for (Interval interval : intervalsList) {
            if (interval.end < insert.start)
                result.add(interval);
            else if (interval.start > insert.end) {
                result.add(insert);
                insert = interval;
            } else if (interval.end >= insert.start || interval.start <= insert.end) {
                insert = new Interval(Math.min(interval.start,insert.start), Math.max(interval.end, insert.end));
            }
        }
        result.add(insert);
        return result;
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
