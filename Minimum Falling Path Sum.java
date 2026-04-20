class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = Integer.MAX_VALUE;

        for(int j=0; j<n; j++){
            ans = Math.min(ans, solve(0,j,m,n,matrix));
        }
        return ans;
    }
    public int solve(int i, int j, int m, int n, int[][] matrix){
        if(i >= m || j>= n ||i < 0 || j< 0) return Integer.MAX_VALUE;
        if(i==m-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];

        int diag = solve(i+1,j+1,m,n,matrix);
        int belo = solve(i+1, j, m, n, matrix);
        int diag2 = solve(i+1, j-1, m, n, matrix);

        return dp[i][j] =  matrix[i][j]+ Math.min(Math.min(diag,diag2), belo);
    }
}

//Bottom -up
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int rmcm = (j-1>=0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rmc = (i-1 >= 0) ? dp[i-1][j] : Integer.MAX_VALUE;
                int rmcp = (j+1 <=n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(rmcm, Math.min(rmc,rmcp));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[m-1][j]);
        }
        return ans;

    }
}