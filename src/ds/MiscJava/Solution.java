package ds.MiscJava;

/**
 * Created by senthil on 12/8/16.
 */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}
public class Solution {

    public void test(Node n, int data) {
        n.data = data;
    }

    public static void main(String a[]) {
        Solution  s = new Solution();
        Node n = new Node(100);
        s.test(n, 200);
        System.out.println(n.data);
        //Node p = n;
        Node p = new Node(n.data);
        System.out.println(p.data);
        s.test(n, 300);
        System.out.println(p.data);
        s.test(p, -200);
        System.out.println(p.data);
        s.test(p, 400);
        System.out.println(p.data);

    }
}
