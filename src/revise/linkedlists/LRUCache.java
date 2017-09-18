package revise.linkedlists;

import java.util.HashMap;
import java.util.Map;

class DoublyListNode {
    int data;
    DoublyListNode next;
    DoublyListNode prev;
    DoublyListNode(int data, DoublyListNode next, DoublyListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class LRUCache {
    Map<Object, DoublyListNode> map = new HashMap<>();

    public Object get() {
        return null;
    }
    
}
