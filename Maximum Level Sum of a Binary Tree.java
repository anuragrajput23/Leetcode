class Solution {
    public int maxLevelSum(TreeNode root) {
        //BFS traversal of tree
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int currLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;

        while(!qu.isEmpty()){
            int sum = 0;
            int n = qu.size();
            while(n-- > 0){
                TreeNode temp = qu.poll();
                 sum += temp.val;

            if(temp.left!=null) qu.offer(temp.left);
            if(temp.right!=null) qu.offer(temp.right);

            }
            if(maxSum < sum){
                maxSum = sum;
                level=currLevel;
            }
            currLevel++;
        }
        return level;
    }
}