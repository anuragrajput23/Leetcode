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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while(odd!=null){
            dummy.next = new ListNode(odd.val);
            dummy = dummy.next;
            if(odd.next!=null){
                odd = odd.next.next;
            }else{
                break;
            }
        }
        while(even!=null){
            dummy.next = new ListNode(even.val);
            dummy = dummy.next;
            if(even.next!=null){

                even = even.next.next;
            }else{
                break;
            }
        }
        return ans.next;
    }
}