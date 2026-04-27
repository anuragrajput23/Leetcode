class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        return solve(0,-1,nums);
    }
    public int solve(int i, int prev, int[] nums){
        if(i==nums.length) return 0;
        if(prev==-1 || nums[prev] < nums[i]){
            return Math.max(1+solve(i+1, i, nums), solve(i+1,prev,nums));
        }else{
            return solve(i+1,prev,nums);
        }
    }
}

//memoised
class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n+1];
        return solve(0,-1,nums);
    }
    public int solve(int i, int prev, int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=null) return dp[i][prev+1];
        int take = 0;
        if(prev==-1 || nums[prev] < nums[i]){
            take = 1+solve(i+1, i, nums);
        }
        int ntake = solve(i+1,prev,nums);
        return dp[i][prev+1]= Math.max(ntake,take);

    }
}
//Bottom up
class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int take = 0;
                if(j==-1 || nums[j] < nums[i]){
                    take = 1+dp[i+1][i+1];
                }
                int ntake = dp[i+1][j+1];
                dp[i][j+1] = Math.max(ntake,take);
            }
        }
        return dp[0][0];
    }

}