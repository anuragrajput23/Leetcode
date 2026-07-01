class Solution {
    public void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> list){
        vis[i]=true;
        for(Integer it : list.get(i)){
            if(vis[it]==false){
                // vis[it]= true;
                dfs(it,vis,list);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(vis[i]==false){
                cnt++;
                dfs(i,vis,list);
            }
        }
        return cnt;
    }
}