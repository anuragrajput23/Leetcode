class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return solve(prices,0,1);
    }
    public int solve(int[] prices, int i, int flag){
        int profit = 0;
        if(i>=prices.length) return 0;
        if(flag==1){
            profit += Math.max(-prices[i] + solve(prices, i+1, 0), solve(prices, i+1, 1));
        }else{
            profit += Math.max(prices[i] + solve(prices, i+2, 1), solve(prices, i+1, 0));
        }
        return profit;
    }
}

//memoisation
class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];
        return solve(prices,0,1);
    }
    public int solve(int[] prices, int i, int flag){
        int profit = 0;
        if(i>=prices.length) return 0;
        if(dp[i][flag]!=null) return dp[i][flag];
        if(flag==1){
            profit += Math.max(-prices[i] + solve(prices, i+1, 0), solve(prices, i+1, 1));
        }else{
            profit += Math.max(prices[i] + solve(prices, i+2, 1), solve(prices, i+1, 0));
        }
        return dp[i][flag] =profit;
    }
}