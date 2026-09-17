class Solution {
    public Node addOne(Node head) {
        // code here.
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        Node ans = new Node(-1);
        Node dummy = ans;
        int carry = 1;
        while(!st.isEmpty()){
            int res = st.pop()+carry;
            if(res >= 10){
                carry = 1;
                dummy.next = new Node(0);
            }else{
                carry = 0;
                dummy.next = new Node(res);
            }
            dummy = dummy.next;
        }
        Node temp1 = reverse(ans.next);
        if(carry == 1){
            Node nn = new Node(1);
            nn.next = temp1;
            return nn;
        }
        return temp1;
    }
    public Node reverse(Node head){
        if(head==null || head.next==null) return head;
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}