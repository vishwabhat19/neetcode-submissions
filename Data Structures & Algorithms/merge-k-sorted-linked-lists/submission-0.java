/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

        //Put the head of every list into the heap
        for(ListNode head : lists) {
            if (head != null) heap.offer(head);
        }

        ListNode dummyNode = new ListNode(0);
        ListNode tail = dummyNode;

        while(!heap.isEmpty()) {
            ListNode smallestNode = heap.poll();
            tail.next = smallestNode;
            tail = tail.next;
            if (smallestNode.next != null)
                heap.offer(smallestNode.next);
        }

        return dummyNode.next;


    }
}
