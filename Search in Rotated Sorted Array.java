class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while(l <= r){
            int mid = l +(r-l)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

//today POTD
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo=0,hi=n-1;
        while(lo <= hi){
            int mid = lo +(hi-lo)/2;
            if(nums[mid]==target) return mid;
            if(nums[lo] <= nums[mid]){
                if(nums[mid] >= target && nums[lo] <= target){
                    hi = mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                if(nums[mid] <= target && nums[hi] >= target){
                    lo=mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}