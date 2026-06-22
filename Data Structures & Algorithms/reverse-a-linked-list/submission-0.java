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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode temp = head.next; //Store it for use later
        ListNode prev = head;
        ListNode next = null;
        head.next = null;
        while (temp!=null) {
            //store temp's next
            next = temp.next;
            //point temp.next to previos
            temp.next = prev;
            //Where is next used ? ah to go to the next node
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
