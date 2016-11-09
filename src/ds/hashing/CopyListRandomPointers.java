package ds.hashing;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {

    int data;
    RandomListNode next, random;

    RandomListNode(int data) {
        this.data = data;
    }
}
public class CopyListRandomPointers {

    RandomListNode head;

    public CopyListRandomPointers(RandomListNode head) {
        this.head = head;
    }

    void print()
    {
        RandomListNode temp = head;
        while (temp != null)
        {
            RandomListNode random = temp.random;
            int randomData = (random != null)? random.data: -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = "+ randomData);
            temp = temp.next;
        }
    }

    public void push(int a) {
        RandomListNode node = new RandomListNode(a);
        node.next = this.head;
        this.head = node;
    }

    public CopyListRandomPointers clone() {

        RandomListNode curr = this.head;
        RandomListNode clone = null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.data);
            map.put(curr, temp);
            curr = curr.next;
        }

        curr = this.head;

        while (curr != null) {
            clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        RandomListNode temp = map.get(head);
        return new CopyListRandomPointers(map.get(this.head));
    }

    public static void main(String a[]) {

        CopyListRandomPointers p = new CopyListRandomPointers(new RandomListNode(5));

        p.push(4);
        p.push(3);
        p.push(2);
        p.push(1);

        // Setting up random references.
        p.head.random = p.head.next.next;
        p.head.next.random =
                p.head.next.next.next;
        p.head.next.next.random =
                p.head.next.next.next.next;
        p.head.next.next.next.random =
                p.head.next.next.next.next.next;
        p.head.next.next.next.next.random =
                p.head.next;

        // Making a clone of the original linked list.
        CopyListRandomPointers clone = p.clone();

        System.out.println("Original linked list");
        p.print();

        System.out.println("\nCloned linked list");
        clone.print();
        System.out.println(clone.head);
    }
}
