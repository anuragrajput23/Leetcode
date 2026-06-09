class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int ele : nums){
            maxi = Math.max(maxi,ele);
            mini = Math.min(mini,ele);
        }
       return (long)k*(maxi-mini);
    }
}