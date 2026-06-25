class Solution {
    Integer[][] dp;
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        dp = new Integer[n+1][amt+1];
        int total = solve(0,n,coins,amt);
        if(total == (int)1e9) return -1;
        return total;
    }
    public int solve(int i, int n, int[] coins, int amt){
        if(amt==0) return 0;
        if(i==n) return (int)1e9;
        if(dp[i][amt]!=null) return dp[i][amt];
        int take = (int)1e9;
        if(coins[i] <= amt){
            take = 1+solve(i,n,coins,amt-coins[i]);
        }
        int ntake = solve(i+1,n,coins,amt);
        return dp[i][amt]= Math.min(take,ntake);
    }
}

class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        dp = new int[n+1][amt+1];
        for(int i=0; i<n+1; i++) dp[i][0] = 0;
        for(int j=1; j<amt+1; j++) dp[0][j] = (int)1e9;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=amt; j++){
                int take = (int)1e9;
                if(coins[i-1] <= j){
                    take = 1+dp[i][j-coins[i-1]];
                }
                int ntake = dp[i-1][j];
                dp[i][j] = Math.min(ntake,take);
            }
        }
        return dp[n][amt]==(int)1e9 ? -1 : dp[n][amt];
    }
}