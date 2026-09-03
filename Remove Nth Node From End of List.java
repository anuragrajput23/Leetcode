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
        ListNode temp = head;
        int len = 0;
        if(head.next==null) return null;
        while(temp!=null){
            len++;
            temp= temp.next;
        }
        if(len==n) return head.next;
        int target= len-n;
        temp = head;
        while(target > 1){
            temp = temp.next;
            target--;
        }
        if(temp.next.next==null){
            temp.next = null;
        }else{
            temp.next = temp.next.next;
        }
        return head;
    }
}