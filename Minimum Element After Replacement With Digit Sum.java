class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = (int)1e9;
        for(int ele : nums){
            int curr=0;
            while(ele!=0){
                int rem = ele%10;
                curr += rem;
                ele /= 10;
            }
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}