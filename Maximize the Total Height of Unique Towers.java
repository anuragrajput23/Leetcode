class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        int n = maximumHeight.length;
        long ans = 0;
        Arrays.sort(maximumHeight);
        for(int i=n-2; i>=0; i--){
            if(maximumHeight[i] >= maximumHeight[i+1]){
                maximumHeight[i] = maximumHeight[i+1]-1;
            }
        }
        if(maximumHeight[0]<=0) return -1;
        for(int i=0; i<n; i++) ans += maximumHeight[i];
        return ans;
    }
}