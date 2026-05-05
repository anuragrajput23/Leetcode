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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode temp = head;
        int length = 1;
        while(temp.next!=null){
            length++;
            temp = temp.next;
        }
        k=k%length;
        if(k==0) return head;
        int remain = length-k;
        int cnt = 1;
        ListNode slow = head;
        ListNode fast = head.next;
        while(cnt < remain){
            slow = slow.next;
            fast = fast.next;
            cnt++;
        }
        temp.next = head;
        slow.next =null;
        return fast;
    }
}