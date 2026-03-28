class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if((nums[i]==1 && nums[j]==2 || (nums[i]==2 && nums[j]==1))){
                    mini = Math.min(mini, Math.abs(j-i));
                }
            }
        }
        if(mini==Integer.MAX_VALUE) return -1;
        return mini;
    }
}