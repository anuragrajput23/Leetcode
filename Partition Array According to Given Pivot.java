class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int j=0;
        for(int ele : nums){
            if(ele < pivot){
                ans[j++] = ele;
            }
        }
        for(int ele : nums){
            if(ele==pivot){
                ans[j++] = ele;
            }
        }
        for(int ele : nums){
            if(ele>pivot){
                ans[j++] = ele;
            }
        }
        return ans;
    }
}