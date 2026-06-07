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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int[] des : descriptions){
            int p = des[0];
            int c = des[1];
            int l = des[2];
            if(!map.containsKey(p)){
                map.put(p,new TreeNode(p));
            }
            if(!map.containsKey(c)){
                map.put(c,new TreeNode(c));
            }
            if(l==1){
                map.get(p).left = map.get(c);
            }else{
                map.get(p).right = map.get(c);
            }
            set.add(c);
        }
        for(int[] d : descriptions){
            int p = d[0];
            if(!set.contains(p)){
                return map.get(p);
            }
        }
        return null;
    }
}