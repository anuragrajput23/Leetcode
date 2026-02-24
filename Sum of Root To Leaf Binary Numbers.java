/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // ArrayList<Integer> list = new ArrayList<>();
        return solve(root,0);


    }
    public int solve(TreeNode root, int vall){
        //NLR
        if(root==null) return 0;
        vall = 2*vall + root.val;
        if(root.left==null && root.right==null){
            return vall;
        }
        int leftsum = solve(root.left,vall);
        int rightsum = solve(root.right,vall);
        return leftsum+rightsum;
    }
}