package Revise.linkedlists;


class FlattenListNode {
    int val;
    FlattenListNode next;
    FlattenListNode child;
    FlattenListNode(int data, FlattenListNode next, FlattenListNode child) {
        this.val = data;
        this.next = next;
        this.child = child;
    }
}
