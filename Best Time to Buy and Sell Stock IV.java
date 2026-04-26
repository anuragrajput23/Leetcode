class Solution {
    Integer[][][] dp;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][k+1];
        return solve(prices,0,1,k);
    }
    public int solve(int[] prices, int i, int flag, int limit){
        int profit = 0;
        if(limit==0) return 0;
        if(i==prices.length) return 0;
        if(dp[i][flag][limit]!=null) return dp[i][flag][limit];

        if(flag==1){
            profit += Math.max(-prices[i]+solve(prices,i+1,0,limit), solve(prices,i+1,1,limit));
        }else{
              profit += Math.max(prices[i]+solve(prices,i+1,1,limit-1),solve(prices,i+1,0,limit));
        }
        return dp[i][flag][limit] =profit;
    }
}