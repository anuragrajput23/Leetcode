class Solution {
    int[][] dp;
    public int minDifficulty(int[] job, int d) {
        int n = job.length;
        dp = new int[n][d+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        if(n < d) return -1;
        return solve(job,0,d,n);
    }
    public int solve(int[] job,int idx, int d, int n){
        int maxi=-1;
        if(d==1){
            for(int i=idx; i<n; i++){
                maxi = Math.max(maxi,job[i]);
            }
            return maxi;
        }
        if(dp[idx][d]!=-1) return dp[idx][d];
        int maxiDiff = Integer.MIN_VALUE;
        int miniAns = Integer.MAX_VALUE;
        for(int i=idx; i<=n-d; i++){
            maxiDiff = Math.max(maxiDiff, job[i]);
            int check = maxiDiff + solve(job, i+1, d-1, n);
            miniAns = Math.min(check, miniAns);
        }
        return dp[idx][d] =miniAns;
    }
}