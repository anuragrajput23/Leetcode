class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int maxiIdx = Integer.MAX_VALUE;
        int miniIdx=  Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(maxi < nums[i]){
                maxi = nums[i];
                maxiIdx = i;
            }
            if(mini > nums[i]){
                mini = nums[i];
                miniIdx = i;
            }
        }
        int result = n;
        if(maxiIdx < miniIdx){
            result = Math.min((n-miniIdx + maxiIdx+1), result);
            result = Math.min(n-maxiIdx,result);
            result = Math.min(1+miniIdx, result);
        }else{
            result = Math.min(miniIdx+1 + n - maxiIdx, result);
            result = Math.min(maxiIdx+1, result);
            result = Math.min(n-miniIdx,result);
        }
        return result;
    }
}