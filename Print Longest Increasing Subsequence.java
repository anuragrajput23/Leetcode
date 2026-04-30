class Solution {
    public ArrayList<Integer> getLIS(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] dp = new int[n];
        int[] prevIdx = new int[n];
        Arrays.fill(prevIdx,-1);
        int maxiLen = 1;
        int lis = -1;
        int lisIdx = 0;
        Arrays.fill(dp,1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] >  nums[j]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        prevIdx[i] =j;
                        if(lis < dp[i]){
                            lis = dp[i];
                            lisIdx = i;
                        }
                    }
                }
            }
        }
        while(lisIdx!=-1){
            ans.add(nums[lisIdx]);
            lisIdx = prevIdx[lisIdx];
        }
        Collections.reverse(ans);
        return ans;
    }
}
