package ds.stacks;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by senthil on 25/5/16.
 */
class SNode implements Comparable<SNode>{
    int index = 0;
    int val = 0;

    SNode(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public int compareTo(SNode sNode) {
        return Integer.compare(sNode.val, val);
    }
}


public class SlidingWindow {

    public static void main(String args[]) {

        int[] a = new int[] {1,3,-1,-3,5,3,6,7};
        //int[] a = new int[] {4,3,2,1,2,6,5};
        int W = 3;
        Deque<Integer> q = new LinkedList<>();
        List<Integer> rs = new ArrayList<>();
        for(int i = 0; i < W; i++) {
            while(!q.isEmpty() && a[q.peekLast()] <= a[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }

        for(int i = W; i < a.length; i++) {
            rs.add(a[q.peekFirst()]);

            while(!q.isEmpty() && q.peekFirst() <= i-W) {
                q.removeFirst();
            }
            while(!q.isEmpty() && a[q.peekLast()] <= a[i]) {
                q.removeLast();
            }
            q.addLast(i);
        }
        rs.add(a[q.peekFirst()]);
        for(int data : rs)
            System.out.println(data);

        /*PriorityQueue<SNode> pq = new PriorityQueue<>();
        List<Integer> resultant = new ArrayList<>();
        int W = 3;

        for(int i = 0; i < W; i++) {
            pq.add(new SNode(i, a[i]));
        }

        for(int i=W; i<a.length; i++) {
            resultant.add(pq.peek().val);

            while(!pq.isEmpty() && pq.peek().index <= i-W) {
                pq.remove();
            }
            pq.add(new SNode(i, a[i]));
        }
        resultant.add(pq.peek().val);

        for(int data : resultant)
            System.out.println(data);*/


        /*TreeMap<Integer,Integer> counts = new TreeMap<Integer,Integer>();
        for (int i = 0 ; i != W ; i++) {
            if (counts.containsKey(data[i])) {
                counts.put(data[i], counts.get(data[i])+1);
            } else {
                counts.put(data[i], 1);
            }
        }
        for (int i = W ; i != data.length ; i++) {
            Integer max = counts.lastKey();
            System.out.println(max);
            int tmp = counts.get(data[i-W])-1;
            if (tmp != 0) {
                counts.put(data[i-W], tmp);
            } else {
                counts.remove(data[i-W]);
            }
            if (counts.containsKey(data[i])) {
                counts.put(data[i], counts.get(data[i])+1);
            } else {
                counts.put(data[i], 1);
            }
        }
        System.out.println(counts.lastKey());*/

    }
}
