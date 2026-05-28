public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum%2==1) return false;
        return solve(0,n,nums,sum/2);
    }
    public boolean solve(int i, int n, int[] nums, int target){
        if(target==0) return true;
        if(i==n) return false;
        boolean take =  false;
        if(nums[i] <= target){
            take = solve(i+1,n,nums,target-nums[i]);
        }
        boolean ntake = solve(i+1,n,nums,target);
        return take | ntake;
    }
}

class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum%2==1) return false;
        dp = new Boolean[n][sum/2+1];
        return solve(0,n,nums,sum/2);
    }
    public boolean solve(int i, int n, int[] nums, int target){
        if(target==0) return true;
        if(i==n) return false;
        if(dp[i][target]!=null) return dp[i][target];
        boolean take =  false;
        if(nums[i] <= target){
            take = solve(i+1,n,nums,target-nums[i]);
        }
        boolean ntake = solve(i+1,n,nums,target);
        return dp[i][target] =take | ntake;
    }
}
