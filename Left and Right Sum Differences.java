class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] right = new int[n];
        right[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            right[i] =right[i+1]+ nums[i+1];
        }
        int left = 0;
        for(int i=0; i<n; i++){
            result[i] = Math.abs(right[i]-left);
            left += nums[i];
        }
        return result;
    }
}