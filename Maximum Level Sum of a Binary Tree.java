// class Solution {
//     public int maxLevelSum(TreeNode root) {
//         //BFS traversal of tree
//         Queue<TreeNode> qu = new LinkedList<>();
//         qu.offer(root);
//         int currLevel = 1;
//         int maxSum = Integer.MIN_VALUE;
//         int level = 0;

//         while(!qu.isEmpty()){
//             int sum = 0;
//             int n = qu.size();
//             while(n-- > 0){
//                 TreeNode temp = qu.poll();
//                  sum += temp.val;

//             if(temp.left!=null) qu.offer(temp.left);
//             if(temp.right!=null) qu.offer(temp.right);

//             }
//             if(maxSum < sum){
//                 maxSum = sum;
//                 level=currLevel;
//             }
//             currLevel++;
//         }
//         return level;
//     }
// }

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int maxLevelSum(TreeNode root) {
        dfs(root,1);
        int maxSum = Integer.MIN_VALUE;
        int level=0;
        for(int ele : map.keySet()){
            int freq = map.get(ele);
            if(freq > maxSum){
                maxSum = freq;
                level = ele;
            }
        }
        return level;
    }
    public void dfs(TreeNode root, int l){
        if(root==null) return;
        // map.put(l,map.getOrDefault(l)+root.val,0);
        int sum = map.getOrDefault(l,0)+root.val;
        map.put(l,sum);
        dfs(root.left, l+1);
        dfs(root.right, l+1);
    }
}