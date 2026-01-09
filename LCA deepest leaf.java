class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxD = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root,0);
        return lca(root);
    }
    public void depth(TreeNode root, int d){
        if(root==null) return;
        map.put(root.val, d);
        maxD = Math.max(d, maxD);
        depth(root.left,d+1);
        depth(root.right,d+1);
    }
    public TreeNode lca(TreeNode root){
        if(root==null || map.getOrDefault(root.val,0)==maxD) return root;

        TreeNode leftN = lca(root.left);
        TreeNode rightN = lca(root.right);
        if(leftN!=null && rightN!=null) return root;
        if(leftN!=null) return leftN;
        return rightN;
    }
}
