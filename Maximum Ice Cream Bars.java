class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int ans = 0;
        Arrays.sort(costs);
        for(int bar : costs){
            if(coins-bar >= 0){
                ans++;
                coins -= bar;
            }else{
                break;
            }
        }
        return ans;
    }
}