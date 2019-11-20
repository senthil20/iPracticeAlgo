package DataStructures.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 Given an array of integers, sort the array into a wave like array and return it,
 In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

 Example

 Given [1, 2, 3, 4]

 One possible answer : [2, 1, 4, 3]
 Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
        if (a == null) return a;
        Collections.sort(a);
        int s = 0;
        int e = a.size();
        while (s < e) {
            if (s > 0 && a.get(s - 1) > a.get(s)) swap(a, s, s - 1);
            if (s < e - 1 && a.get(s) < a.get(s + 1)) swap(a, s, s + 1);
            s = s + 2;
        }
        return a;
    }

    public void swap(ArrayList<Integer> a, int s, int e) {
        int temp = a.get(s);
        a.set(s, a.get(e));
        a.set(e, temp);
    }

    public static void main(String a[]) {
        WaveArray wa = new WaveArray();
        ArrayList<Integer> list = new ArrayList<>();
        //list.add(5);list.add(1);list.add(3);list.add(2);list.add(4);
        list.add(45);list.add(61);
        wa.wave(list);
    }
}
