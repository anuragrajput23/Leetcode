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