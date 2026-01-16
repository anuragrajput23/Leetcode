class Solution {
    int mod = 1000000007;
    int[][][] dp;
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m+1][n+1][k];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int o=0; o<k; o++){
                    dp[i][j][o] = -1;
                }
            }
        }

        return solve(0,0,m,n,0,grid,k);
    }
    public int solve(int i, int j, int m, int n, int sum, int[][] grid, int k){
        if(i==m-1 && j==n-1){
            if((sum + grid[i][j]%k)%k==0) return 1;
           else  return 0;
        }
        if(i==m || j==n) return 0;
        if(dp[i][j][sum]!=-1) return dp[i][j][sum];

        int rightmove = solve(i+1,j,m,n,(sum%k + grid[i][j]%k)%k,grid,k);
        int downmove = solve(i,j+1,m,n,(sum%k + grid[i][j]%k)%k,grid,k);
        return  dp[i][j][sum]= (rightmove+downmove)%mod;
    }
}