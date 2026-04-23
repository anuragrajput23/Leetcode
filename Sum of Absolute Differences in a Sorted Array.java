class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] pfsum = new int[n];
        pfsum[0] = nums[0];
        for(int i=1; i<n; i++){
            pfsum[i] = pfsum[i-1] + nums[i];
        }
        for(int i=0; i<n; i++){
            //ans[i] = (nums[i]*i - (0 to i-1 ka sum) + (i+1 to n-1 ka sum) - (nums[i]*(n-i-1)));
            int leftsum = pfsum[i] - nums[i];
            int rightsum = pfsum[n-1] - pfsum[i];
            ans[i] = (nums[i]*i) - leftsum + rightsum -(nums[i]*(n-i-1));
        }
        return ans;

    }
}