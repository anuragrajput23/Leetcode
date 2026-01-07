class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int level = 0;

        while(!qu.isEmpty()){
            int n = qu.size();
            long sum = 0;
            while(n-- > 0){
                TreeNode temp = qu.poll();
                sum += temp.val;
                if(temp.left!=null) qu.offer(temp.left);
                if(temp.right!=null) qu.offer(temp.right);

            }
            level++;
            pq.add(sum);
        }
        if(level < k) return -1;
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
