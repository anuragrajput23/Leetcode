class Solution {
    public Node segregate(Node head) {
        // code here
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.data==0) cnt0++;
            else if(temp.data==1) cnt1++;
            else cnt2++;
            temp = temp.next;
        }
        Node ans = new Node(-1);
        Node dummy = ans;
        while(cnt0-->0){
            dummy.next = new Node(0);
            dummy = dummy.next;
        }
        while(cnt1-->0){
            dummy.next = new Node(1);
            dummy = dummy.next;
        }
        while(cnt2-->0){
            dummy.next = new Node(2);
            dummy = dummy.next;
        }
        return ans.next;
    }

}