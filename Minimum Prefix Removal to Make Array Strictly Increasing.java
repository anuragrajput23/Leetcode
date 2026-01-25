class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int i=n-2;
        int j=n-1;

        while(i>=0){
            if(nums[j]>nums[i]){
                i--;
                j--;
            }
            else{
                return j;
            }
        }
        return 0;
    }
}