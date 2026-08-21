class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] color = new int[v];
        return solve(0,edges,color,m);
    }
    public static boolean solve(int node,int[][] edges, int[] color, int m){
        if(node==color.length) return true;
        for(int i=1; i<=m; i++){
            if(isSafe(node,i,edges,color,m)){
                color[node]=i;
                if(solve(node+1,edges,color,m)==true) return true;
                else color[node]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int node, int i, int[][]edges, int[] color, int m){
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (u == node && color[v] == i) {
                return false;
            }

            if (v == node && color[u] == i) {
                return false;
            }
        }
        return true;
    }
}