class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return solve(prices,0,1,fee);
    }
    public int solve(int[] prices, int i, int flag, int fee){
        int profit =0;
        if(i==prices.length) return 0;
        if(flag==1){
            profit += Math.max(-prices[i] + solve(prices,i+1,0,fee), solve(prices, i+1, 1,fee));
        }else{
            profit += Math.max(prices[i]-fee + solve(prices,i+1,1,fee), solve(prices,i+1,0,fee));
        }
        return profit;
    }
}