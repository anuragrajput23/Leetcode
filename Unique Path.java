// class Solution {
//     int dp[][];
//     public int uniquePaths(int m, int n) {
//         dp = new int[m][n];
//         for(int[] row : dp) Arrays.fill(row,-1);
//         return solve(0,0,m,n);
//     }
//     public int solve(int i, int j, int m, int n){
//         if(i==m || j==n) return 0;
//         if(i==m-1 && j==n-1){
//             return 1;
//         }
//         if(dp[i][j]!=-1) return dp[i][j];
//         int rightward = solve(i+1,j,m,n);
//         int downward = solve(i,j+1,m,n);
//         return dp[i][j]= rightward + downward;
//     }
// }

//Tabulation way
class Solution {
    public int uniquePaths(int m, int n) {
    int dp[][] = dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0) dp[i][j] = 1;
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }

}