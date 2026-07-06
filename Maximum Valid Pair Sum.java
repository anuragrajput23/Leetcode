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

class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] suf = new int[n];
        suf[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            suf[i]= Math.max(suf[i+1],nums[i]);
        }
        for(int i=0; i<n-k; i++){
            ans = Math.max(ans, nums[i]+suf[i+k]);
        }
        return ans;
    }
}