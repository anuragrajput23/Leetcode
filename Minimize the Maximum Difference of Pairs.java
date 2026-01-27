class Solution {
    public boolean isValidate(int[] nums, int check, int p){
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i] <= check){
                cnt++;
                i++;
            }
        }
        return cnt>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int mini = nums[n-1] - nums[0];
        int ans = 0;

        int l=0;
        int r=mini;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isValidate(nums,mid,p)){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}