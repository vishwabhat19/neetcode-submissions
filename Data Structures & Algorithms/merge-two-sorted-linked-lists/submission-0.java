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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Queue<ListNode> q = new LinkedList();

        while(list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                q.offer(list1);
                list1 = list1.next;
            }
            else {
                q.offer(list2);
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            q.offer(list1);
        }

        if (list2 != null) {
            q.offer(list2);
        }

        ListNode head = q.poll();

        ListNode temp = head;

        while(!q.isEmpty()) {
            temp.next = q.poll();
            temp = temp.next;
        }

        return head;
    }
}