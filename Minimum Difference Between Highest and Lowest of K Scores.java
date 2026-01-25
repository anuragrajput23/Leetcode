class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        // return Math.abs(nums[0]-nums[k-1]);
         int cnt = 0;
         int ans = Integer.MAX_VALUE;;
         int r=0,l=0;

        while(r<n){
            cnt++;
            while(cnt > k){
                l++;
                cnt--;
            }
        if(cnt==k) ans = Math.min(Math.abs(nums[r]-nums[l]),ans);
        r++;
        }
        return ans;
    }
}