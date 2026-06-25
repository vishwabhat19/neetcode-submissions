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
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        //Reverse the list starting from head2

        ListNode temp = null;
        if (head2!=null) temp = head2.next;
        head2.next = null;
        ListNode prev = head2;
        ListNode next;

        while(temp!=null) {
                next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
        }

        //prev has the second linkedlist which is in reversed order

        ListNode temp1 = head;
        ListNode temp2 = prev;
        int n = 0;

        while(temp1!=null && temp2!=null) {
                if (n%2==0) {
                        temp = temp1.next;
                        temp1.next = temp2;
                        temp1 = temp;
                        n++;
                }
                else {
                        temp = temp2.next;
                        temp2.next = temp1;
                        temp2 = temp;
                        n++;
                }
        }

       


    }
}
