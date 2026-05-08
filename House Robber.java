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
//space optimisation
class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n];
       dp[0] = nums[0];

       for(int i=1; i<n; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }
            int ntake = dp[i-1];
            dp[i] = Math.max(take,ntake);
       }
       return dp[n-1];
    }
}
