class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int maxi = nums[0];
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi, nums[i]);
            int mini = Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
               mini = Math.min(mini, nums[j]);
            }
            if(maxi-mini <= k) return i;
        }
        return -1;
    }
}