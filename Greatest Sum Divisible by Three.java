class Solution {
    int[][] dp;
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][3];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0,n,0,nums);
    }
    public int solve(int i, int n, int sum, int[] nums){
        if(i==n){
            return sum== 0 ? 0 : Integer.MIN_VALUE;
        }
        if(dp[i][sum]!=-1) return dp[i][sum];

        int take =nums[i]+ solve(i+1,n,(sum+nums[i])%3,nums);
        int ntake = solve(i+1,n,sum,nums);
        return dp[i][sum]= Math.max(ntake,take);
    }
}