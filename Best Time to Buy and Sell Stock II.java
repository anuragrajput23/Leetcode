class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        return solve(prices,0,1,0);
    }
    public int solve(int[] prices, int i, int flag, int profit){
        if(i==prices.length) return 0;
        if(flag==1){
            profit += Math.max(-prices[i] + solve(prices,i+1,0,profit), solve(prices,i+1,1,profit));
        }else{
            profit += Math.max(prices[i] + solve(prices,i+1, 1,profit), solve(prices,i+1,0,profit));
        }
        return profit;
    }
}