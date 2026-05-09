class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        if(n==1) return nums[0];
        return Math.max(solve(0,n-1,nums,dp1), solve(1,n,nums,dp2));
    }
    public int solve(int i, int n, int[] nums, int[] dp){
        if(i>=n) return 0;
        if(i==n-1) return nums[i];
        if(dp[i]!=-1) return dp[i];
        int take = Math.max(nums[i] + solve(i+2,n,nums,dp), solve(i+1,n,nums,dp));
        return dp[i]= take;
    }
}

//space optimised and complexity too
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i!=0) list1.add(nums[i]);
            if(i!=n-1) list2.add(nums[i]);
        }
        return Math.max(solve(list1), solve(list2));
    }
    public int solve(ArrayList<Integer> list){
        int n = list.size();
        int prev2 = 0;
        int prev1 = list.get(0);
        for(int i=1; i<n; i++){
            int take = list.get(i);
            if(i-2 >=0){
                take += prev2;
            }
            int ntake = prev1;
            int curr = Math.max(take,ntake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}