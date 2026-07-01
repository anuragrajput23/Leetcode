class Solution {
    public void dfs_check(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans){
        ans.add(i);
        vis[i]=true;
        for(int it : adj.get(i)){
            if(vis[it]==false){
                dfs_check(it,adj,vis,ans);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        vis[0]=true;
        int st = 0;
        dfs_check(st,adj,vis,ans);
        return ans;
    }
}