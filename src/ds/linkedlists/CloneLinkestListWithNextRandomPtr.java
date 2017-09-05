package ds.linkedlists;

import java.util.*;

class ListNode1 implements Comparable<ListNode1>{
    int val;
    ListNode1 next;
    ListNode1 random;
    ListNode1(int val) {
        this.val = val;
    }
    public ListNode1() {
    }

    @Override
    public int compareTo(ListNode1 o) {
        return this.val - o.val;
    }
}

public class CloneLinkestListWithNextRandomPtr {

    public static void cloneList(ListNode1 head) {
        System.out.println(head);
        Map<ListNode1, List<Integer>> map = new TreeMap<>();
        while (head != null) {
            List<Integer> list = new ArrayList<>();
            if (head.next != null) list.add(head.next.val);
            if (head.random != null) list.add(head.random.val);
            map.put(new ListNode1(head.val), list);
            head = head.next;
        }
        ListNode1 result = null;
        ListNode1 temp = null;
        ListNode1 key = (ListNode1) map.keySet().iterator().next();
        while (key != null && map.containsKey(key)) {
            List<Integer> val = map.get(key);
            if (result == null) {
                temp = key;
                result = temp;
            }
            if (!val.isEmpty()) {
                temp.next = new ListNode1(val.get(0));
                temp.random = new ListNode1(val.get(1));
            }
            temp = temp.next;
            key = temp;
        }
        System.out.println(result);
    }

    public static void main(String a[]) {
        ListNode1 p = new ListNode1(-1);
        ListNode1 l1 = new ListNode1(1);
        ListNode1 l2 = new ListNode1(2);
        ListNode1 l3 = new ListNode1(3);
        ListNode1 l4 = new ListNode1(4);
        ListNode1 l5 = new ListNode1(5);
        p.next = l1;
        l1.next = l2;
        l1.random = l3;
        l2.next = l3;
        l2.random = l1;
        l3.next = l4;
        l3.random = l5;
        l4.next = l5;
        l4.random = l5;
        cloneList(p.next);
    }
}
