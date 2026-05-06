class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return solve(0,0,m,n,text1,text2);
    }
    public int solve(int i, int j, int m, int n, String s1, String s2){
        if(i==m || j==n) return 0;
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+solve(i+1,j+1,m,n,s1,s2);
        }else{
            return Math.max(solve(i+1,j,m,n,s1,s2),solve(i,j+1,m,n,s1,s2));
        }
    }
}

//optimised using buttom-up
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}