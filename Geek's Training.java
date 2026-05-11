class Solution {
    Integer[][] dp;
    public int maximumPoints(int mat[][]) {
        int m = mat.length;
        dp  = new Integer[m][4];
        return solve(m-1,3,m,mat);
    }
    public int solve(int days, int last, int m, int[][] mat){
        if(days==0){
            int currmaxi = 0;
            for(int i=0; i<3; i++){
                if(i!=last) currmaxi = Math.max(currmaxi, mat[days][i]);
            }
            return currmaxi;
        }
        if(dp[days][last]!=null) return dp[days][last];
        int total = 0;
        if(days<m){
            for(int i=0; i<3; i++){
                if(i!=last){
                    int instant = mat[days][i] + solve(days-1,i,m,mat);
                    total = Math.max(total,instant);
                }
            }
        }
        return dp[days][last]= total;
    }
}