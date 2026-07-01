public class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();
        vis[0]=true;
        qu.offer(0);
        while(!qu.isEmpty()){
            int node = qu.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                if(vis[it]==false){
                    qu.add(it);
                    vis[it]=true;
                }
            }
        }
        return ans;
    }
}
