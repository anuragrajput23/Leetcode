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

//another method
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int less = 0;
        int equal = 0;
        int large = 0;
        int[] result = new int[n];
        for(int ele : nums){
            if(ele < pivot){
                less++;
            }else if(ele==pivot){
                equal++;
            }else{
                large++;
            }
        }
        int k=0;
        int l=less;
        int m = less+equal;
        for(int i=0; i<n; i++){
            if(nums[i] < pivot) result[k++]=nums[i];
            else if(nums[i] == pivot) result[l++] = nums[i];
            else result[m++]=nums[i];
        }
        return result;
    }
}