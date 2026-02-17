class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        Stack<Long> st = new Stack<>();
        for(int i=0; i<n; i++){
            Long current = (long)nums[i];
            while(!st.isEmpty() && st.peek().equals(current)){
                st.pop();
                current = 2*current;
            }
            st.push((long)current);

        }
        // while(!st.isEmpty()){
        //     ans.add(st.peek());
        //     st.pop();
        // }
        // Collections.reverse(ans);

        List<Long> ans = new ArrayList<>(st);
        return ans;
    }
}