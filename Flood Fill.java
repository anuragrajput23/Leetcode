class Solution {
    public void dfs(int sr, int sc,int color, int iniColor, boolean[][] vis, int[] drow, int[] dcol, int[][] image, int[][] ans){
        int n = image.length;
        int m = image[0].length;
        ans[sr][sc]=color;
        vis[sr][sc]=true;
        for(int i=0; i<4; i++){
            int nr = sr+drow[i];
            int nc = sc + dcol[i];
            if(nr>=0 && nr <n && nc >= 0 && nc < m && image[nr][nc]==iniColor && vis[nr][nc]==false){
                ans[sr][sc]=color;
                vis[nr][sc]=true;
                dfs(nr,nc,color,iniColor,vis,drow,dcol,image,ans);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] ans = image;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,1,0,-1};
        int iniColor = image[sr][sc];
        dfs(sr,sc,color,iniColor,vis,drow,dcol,image,ans);
        return ans;
    }
}