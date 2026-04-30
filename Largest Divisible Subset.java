class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,-1,result,curr,nums);
        return result;
    }
    public void solve(int i,int prev, List<Integer> result, List<Integer> curr, int[] nums){
        if(i>=nums.length){
            if(curr.size() > result.size()){
                result.clear();
                result.addAll(curr);
            }
            return;
        }
        if(prev==-1 || nums[i]%nums[prev]==0){
            curr.add(nums[i]);
           solve(i+1,i, result, curr, nums);
        curr.remove(curr.size() - 1);
        }
        solve(i+1,prev,result,curr,nums);
    }
}

//optimisation
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
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
                if(nums[i] %  nums[j] == 0){
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
        //
        while(lisIdx!=-1){
            ans.add(nums[lisIdx]);
            lisIdx = prevIdx[lisIdx];
        }
        Collections.reverse(ans);
        return ans;
    }
}