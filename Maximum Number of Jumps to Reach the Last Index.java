class Solution {
    Integer[][] dp;
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        dp = new Integer[n+1][n+1];
        int check= solve(0,1,nums,target);
        if(check==Integer.MIN_VALUE) return -1;
        return check;
    }
    public int solve(int i, int j, int[] nums, int target){
        if(j>=nums.length) return Integer.MIN_VALUE;
        if(j==nums.length-1){
            if(nums[j]-nums[i] >= -target && nums[j]-nums[i] <= target){
                return 1;
            }else{
                return Integer.MIN_VALUE;
            }
        }
        if(dp[i][j]!=null) return dp[i][j];
        int take = Integer.MIN_VALUE;
        int ntake = solve(i,j+1,nums,target);
        if(nums[j]-nums[i] >= -target && nums[j]-nums[i] <= target){
            int next =  solve(j,j+1, nums,target);
            if(next!=Integer.MIN_VALUE){
                take = 1+ next;
            }
        }
        return dp[i][j]= Math.max(take,ntake);
    }
}
