class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=n-1;
        int ans = 0;

        while(i<=j){
            int sum = nums[i]+nums[j];
            ans = Math.max(sum,ans);
            i++;
            j--;
        }
        return ans;
    }
}