class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int mini = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]==target) mini = Math.min(Math.abs(i-start),mini);
        }
        return mini;
    }
}