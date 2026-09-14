class Solution {
    public int averageOfSubtree(TreeNode root) {
        return solve(root);
    }
    public int solve(TreeNode root){
        int result = 0;
        if(root==null) return 0;
        int[] data = findsum(root);
        if(root.val == data[0]/data[1]) result++;
       result += solve(root.left);
        result += solve(root.right);
        return result;
    }
    public int[] findsum(TreeNode root){
        int[] data = new int[2];
        if(root==null){
            return new int[]{0,0};
        }
        int[] left = findsum(root.left);
        int[] right = findsum(root.right);
        int sum = left[0]+right[0]+root.val;
        int cnt = left[1]+right[1]+1;
        return new int[]{sum,cnt};
    }
}