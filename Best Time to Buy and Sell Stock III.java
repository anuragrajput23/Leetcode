//recursive approach
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return solve(prices,0,1,2);
    }
    public int solve(int[] prices, int i, int flag, int limit){
        int profit = 0;
        if(limit==0) return 0;
        if(i==prices.length) return 0;

        if(flag==1){
            profit += Math.max(-prices[i]+solve(prices,i+1,0,limit), solve(prices,i+1,1,limit));
        }else{
              profit += Math.max(prices[i]+solve(prices,i+1,1,limit-1),solve(prices,i+1,0,limit));
        }
        return profit;
    }
}

class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2][3];
        return solve(prices,0,1,2);
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