class Solution {
    Integer[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][k+1];
        int res =  solve(0,0,m,n,grid,k);
        return res==Integer.MIN_VALUE ? -1 : res;
    }
    public int solve(int i, int j, int m, int n, int[][] grid, int k){
        if(i==m || j==n) return Integer.MIN_VALUE;

        int cost = grid[i][j] == 0 ? 0 : 1;
        k = k - cost;

        if(k < 0) return Integer.MIN_VALUE;

        if(i == m-1 && j == n-1){
            return grid[i][j];
        }
        if(dp[i][j][k]!=null) return dp[i][j][k];
        int bottom = solve(i+1,j,m,n,grid,k);
        int right = solve(i,j+1,m,n,grid,k);
        int best = Math.max(bottom, right);

        if(best == Integer.MIN_VALUE) return best;

        return dp[i][j][k] = grid[i][j] + best;
    }
}