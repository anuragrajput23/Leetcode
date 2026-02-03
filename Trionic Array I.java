class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int k=1;

        while(k < n && nums[k]>nums[k-1]){
            k++;
        }
        if(k==1 || k==n) return false;

        while(k < n && nums[k]<nums[k-1]){
            k++;
        }
        if(k==n) return false;

        while(k<n && nums[k]>nums[k-1]){
            k++;
        }
        if(k==n) return true;
        return false;
    }
}