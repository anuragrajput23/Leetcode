public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        Set<ListNode> set = new HashSet<>();
        while(temp1!=null){
            set.add(temp1);
            temp1 = temp1.next;
        }
        temp1 = headB;
        while(temp1!=null){
            if(set.contains(temp1)){
                return temp1;
            }
            temp1 = temp1.next;
        }
        return null;
    }
}

