class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxLen = -1;
        int cnt = 2;
        for(int i=2; i<n; i++){
            if(nums[i-1]+nums[i-2] == nums[i]){
                cnt++;
            }
            else{
                maxLen = Math.max(cnt,maxLen);
                cnt=2;
            }
        }
        maxLen = Math.max(cnt,maxLen);
        return maxLen;
    }
}