// class Solution {
//     long sum = 0;
//     long maxProd = 0;
//     public long sum(TreeNode root){
//         if(root==null) return 0;
//         return root.val + sum(root.left)+sum(root.right);
//     }
//     public long product(TreeNode root){
//         if(root==null) return 0;
//         long leftSubtreeSum = product(root.left);
//         long rightSubtreeSum = product(root.right);
//         long subTreeSum = root.val + leftSubtreeSum + rightSubtreeSum;
//         long remainTreeSum = sum - subTreeSum;

//         maxProd = Math.max(maxProd, subTreeSum*remainTreeSum);

//         return subTreeSum;
//     }
//     public int maxProduct(TreeNode root) {
//         sum = sum(root);
//         product(root);
//         return (int)(maxProd%1000000007);
//     }
// }

class Solution {
    long sum = 0;
    long maxProd = 0;
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int leftsubtree = dfs(root.left);
        int rightsubtree = dfs(root.right);
        long subtreesum = root.val + leftsubtree + rightsubtree;
        long remain = sum - subtreesum;
        maxProd = Math.max(maxProd, remain*subtreesum);
        return (int)subtreesum;
    }
    public int maxProduct(TreeNode root) {
       sum = dfs(root);
        dfs(root);
        return (int)(maxProd%1000000007);
    }
}
