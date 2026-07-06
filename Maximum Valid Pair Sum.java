class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + k; j < n; j++) {
                ans = Math.max(ans, nums[i] + nums[j]);
            }
        }
        return ans;
    }
}