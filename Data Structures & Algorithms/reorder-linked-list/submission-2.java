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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;


        //Reverse the second list
        ListNode prev = null;
        ListNode curr = head2;
        while(curr != null) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
        }

        ListNode temp1 = head;
        ListNode temp2 = prev;

        while(temp2 != null) {
                ListNode next1 = temp1.next;
                ListNode next2 = temp2.next;

                temp1.next = temp2;
                temp2.next = next1;

                temp1 = next1;
                temp2 = next2;
        }


    }
}
