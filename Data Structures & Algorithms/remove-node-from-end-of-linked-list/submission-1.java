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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        int size = 0;
        ListNode temp = head;
        while(temp!=null) {
                temp = temp.next;
                size++;
        }

        int nodePosition = size - n;
        temp = head;
        int pos = 0;
        ListNode prev = head;
        while(temp!=null) {
                if (nodePosition == pos) {
                        if (temp == head) {
                                head = temp.next;break;
                        }
                        prev.next = temp.next;
                        break;
                }
                pos++;
                prev = temp;
                temp = temp.next;
        }

        return head;
    }
}
