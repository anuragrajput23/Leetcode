public class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       return solve(0,n,nums);
    }
    public int solve(int i, int n, int[] nums){
        if(i>=n) return 0;
        if(i==n-1) return nums[i];
        int take = Math.max(nums[i] + solve(i+2,n,nums), solve(i+1,n,nums));
        return take;
    }
}
//memoisation
class Solution {
    Integer[] dp;
    public int rob(int[] nums) {
       int n = nums.length;
       dp = new Integer[n];
       return solve(0,n,nums);
    }
    public int solve(int i, int n, int[] nums){
        if(i>=n) return 0;
        if(i==n-1) return nums[i];
        if(dp[i]!=null) return dp[i];
        int take = Math.max(nums[i] + solve(i+2,n,nums), solve(i+1,n,nums));
        return dp[i] = take;
    }
}
