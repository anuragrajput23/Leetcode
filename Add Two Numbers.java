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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int carry = 0;
        while(t1!=null || t2!=null){
            int val = (t1!=null ? t1.val : 0) +(t2!=null ? t2.val : 0)+ carry;
            int rem = val%10;
            carry = val/10;
            dummy.next = new ListNode(rem);
            dummy = dummy.next;
            if(t1!=null) t1 = t1.next;
           if(t2!=null) t2 = t2.next;
        }
        if(carry!=0){
            dummy.next = new ListNode(carry);
        }
        return ans.next;
    }
}