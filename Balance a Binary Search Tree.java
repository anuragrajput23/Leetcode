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
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode constructBST(int l, int r, List<Integer> list){
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructBST(l,mid-1,list);
        root.right = constructBST(mid+1,r,list);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int l=0;
        int r=list.size()-1;
        return constructBST(l,r,list);
    }
}