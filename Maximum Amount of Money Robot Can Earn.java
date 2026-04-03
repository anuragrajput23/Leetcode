// class Solution {

//     public int maximumAmount(int[][] coins) {
//         return solve(0, 0, 0, coins);
//     }
//     private int solve(int i, int j, int k, int[][] coins) {
//         int m = coins.length;
//         int n = coins[0].length;

//         if (i >= m || j >= n) return Integer.MIN_VALUE;

//         if (i == m - 1 && j == n - 1) {
//             if (coins[i][j] >= 0) return coins[i][j];
//             else {
//                 if (k < 2) return 0;   // neutralize
//                 return coins[i][j];    // take loss
//             }
//         }

//         int val = coins[i][j];

//         if (val >= 0) {
//             int right = solve(i, j + 1, k, coins);
//             int down  = solve(i + 1, j, k, coins);
//             return val + Math.max(right, down);
//         } else {
//             int right1 = solve(i, j + 1, k, coins);
//             int down1  = solve(i + 1, j, k, coins);
//             int takeLoss = val + Math.max(right1, down1);

//             int neutralize = Integer.MIN_VALUE;
//             if (k < 2) {
//                 int right2 = solve(i, j + 1, k + 1, coins);
//                 int down2  = solve(i + 1, j, k + 1, coins);
//                 neutralize = Math.max(right2, down2);
//             }

//             return Math.max(takeLoss, neutralize);
//         }
//     }
// }

//Memisation:
class Solution {
    int[][][] dp;
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        dp = new int[m][n][3];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(0,0,m,n,2,coins);
    }
    public int solve(int i, int j, int m, int n, int neutro, int[][] coins){
        if(i>=m || j>=n) return Integer.MIN_VALUE;
        if(i==m-1 && j==n-1){
            if(coins[i][j] >= 0){
                return coins[i][j];
            }
            return (neutro > 0) ? 0 : coins[i][j];
        }
        if(dp[i][j][neutro]!=-1) return dp[i][j][neutro];
        int take = Integer.MIN_VALUE;
        if(coins[i][j] >= 0){
            take =coins[i][j]+ Math.max(solve(i,j+1,m,n,neutro,coins),solve(i+1,j,m,n,neutro,coins));
        }
        int ntake = Integer.MIN_VALUE;
        if(coins[i][j] < 0){
            ntake = coins[i][j] + Math.max(solve(i+1,j,m,n,neutro,coins),solve(i,j+1,m,n,neutro,coins));
        }
        int absolute = Integer.MIN_VALUE;
        if(coins[i][j] < 0 && neutro > 0){
            absolute = Math.max(solve(i+1,j,m,n,neutro-1,coins),solve(i,j+1,m,n,neutro-1,coins));
        }
        return dp[i][j][neutro] =Math.max(absolute,Math.max(ntake,take));
    }
}