class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][n];
        return solve(0,0,n-1,grid);
    }
    public int solve(int r, int c1, int c2, int[][] grid){
        int ans = 0;
        if(r>=grid.length || c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) return 0;
        if(r==grid.length-1){
            if(c1==c2){
                return grid[r][c2];
            }else{
                return grid[r][c2]+grid[r][c1];
            }
        }
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int newR1 = r+1;
                int newC1 = c1 + i;
                int newC2 = c2 + j;
                int currBox = 0;
                if(c1==c2){
                    currBox += grid[r][c2];
                }else{
                    currBox += grid[r][c2]+grid[r][c1];
                }
               ans = Math.max(ans,currBox+ solve(newR1, newC1, newC2, grid));
            }
        }
        return dp[r][c1][c2]= ans;
    }
}

class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[71][71][71];
        return solve(0,0,n-1,grid);
    }
    public int solve(int r, int c1, int c2, int[][] grid){
        if(r>=grid.length || c1 < 0 || c1 >= grid[0].length || c2 < 0 || c2 >= grid[0].length) return -(int)1e9;
        int cherry = grid[r][c1];
        if(c1!=c2){
            cherry += grid[r][c2];
        }
        int ans = 0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                int newR1 = r+1;
                int newC1 = c1 + i;
                int newC2 = c2 + j;
                ans = Math.max(ans, solve(newR1, newC1, newC2, grid));
            }
        }
        return dp[r][c1][c2]= ans+cherry;
    }
}

