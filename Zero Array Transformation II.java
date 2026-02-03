class Solution {
    public boolean DAT(int[] nums, int[][] queries, int k){
        int m = queries.length;
        int n1 = nums.length;

        int[] pf = new int[n1];
        for(int i=0; i<=k; i++){
            int l=queries[i][0];
            int r=queries[i][1];

            int x = queries[i][2];
            pf[l] += x;
            if((r+1 <= n1-1)){
                pf[r+1] -= x;
            }
        }
        for(int i=1; i<n1; i++){
            pf[i] += pf[i-1];
        }
        for(int i=0; i<n1; i++){
            if(nums[i] > pf[i]){
                return false;
            }
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int i=0;
        while(i<n && nums[i]==0){
            i++;
        }
        if(i==n) return 0;
        int ans = -1;
        int left = 0;
        int right = q-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(DAT(nums, queries,mid)==true){
                ans = mid+1;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
}