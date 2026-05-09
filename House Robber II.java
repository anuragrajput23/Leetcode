class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        if(n==1) return nums[0];
        return Math.max(solve(0,n-1,nums,dp1), solve(1,n,nums,dp2));
    }
    public int solve(int i, int n, int[] nums, int[] dp){
        if(i>=n) return 0;
        if(i==n-1) return nums[i];
        if(dp[i]!=-1) return dp[i];
        int take = Math.max(nums[i] + solve(i+2,n,nums,dp), solve(i+1,n,nums,dp));
        return dp[i]= take;
    }
}