package revise.linkedlists;

import java.util.HashMap;
import java.util.Map;

class DoublyListNode<T> {
    T key;
    T value;
    DoublyListNode next;
    DoublyListNode prev;
    DoublyListNode(T key, T val, DoublyListNode next, DoublyListNode prev) {
        this.key = key;
        this.value = val;
        this.next = next;
        this.prev = prev;
    }

    public boolean isHeadNode() {
        return this != null && this.prev == null;
    }

    public boolean isTailNode() {
        return this != null && this.next == null;
    }
}

public class LRUCache {

    final int capacity;
    static int currentSize;
    DoublyListNode head;
    DoublyListNode tail;

    LRUCache() {
        capacity = 3;
    }
    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    static Map<Object, DoublyListNode> map = new HashMap<>();

    public Object get(Object key) {
        return map.containsKey(key) ? map.get(key) : null;
    }

    public void put(Object key, Object value) {

        if (head == null && tail == null) {
            head = tail = new DoublyListNode(key, value, null, null);
            map.put(key, head);
            currentSize++;
            return;
        }

        if (map.containsKey(key)) {
            delete(key);
        }
        if (currentSize == capacity) {
            delete(null);
        }
        DoublyListNode temp = new DoublyListNode(key, value, null, null);
        tail.next = temp;
        temp.prev = tail;
        tail = temp;

        map.put(key, temp);

        currentSize++;
    }

    private synchronized void delete(Object key) {

        if (currentSize == 0) return;

        if (key == null) {
            deleteHead();
        }
        else {
            if (!map.containsKey(key)) return;

            DoublyListNode temp = map.get(key);

            if (temp.isTailNode()) {
                deleteTail();
            }
            else if (temp.isHeadNode()) {
                deleteHead();
            }
            else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp.prev = null;
                temp.next = null;
                map.remove(key);
            }
        }
        currentSize--;
    }

    private void deleteHead() {
        map.remove(head.key);
        DoublyListNode next = head.next;
        head.next.prev = null;
        head.next = null;
        head = next;
    }

    private void deleteTail() {
        map.remove(tail.key);
        tail.prev.next = null;
        tail.prev = null;
    }

    public static void main(String a[]) {
        LRUCache lru = new LRUCache(3);
        Integer result = (Integer)lru.get(1);
        lru.put(1, "A");
        lru.put(2, "B");
        lru.put(3, "C");
        System.out.println(lru.head);
        lru.put(4, "A");
        System.out.println(lru.head);
        lru.delete(3);
        System.out.println(lru.head);
    }
}
