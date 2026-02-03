class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] pref = new int[n];
        int q = queries.length;
        for(int i=0; i<q; i++){
            int l = queries[i][0];
            int r = queries[i][1];

            pref[l] += 1;
            if((r+1) <= n-1) pref[r+1] -= 1;
        }
        for(int i=1; i<n; i++){
            pref[i] += pref[i-1];
        }
        for(int i=0; i<n; i++){
            if(nums[i] > pref[i]){
                return false;
            }
        }
        return true;
    }
}