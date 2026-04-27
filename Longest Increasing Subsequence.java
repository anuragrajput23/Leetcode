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