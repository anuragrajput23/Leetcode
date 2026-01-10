class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(0,0,s1,s2);
    }
    public int solve(int i, int j, String s1, String s2){

        if(i >= s1.length() && j>=s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i >= s1.length()) return s2.charAt(j) + solve(i, j+1, s1, s2);
        if(j >= s2.length()) return s1.charAt(i) + solve(i+1, j, s1, s2);
        if(s1.charAt(i)==s2.charAt(j)){
            return solve(i+1, j+1, s1, s2);
        }
        int checki = s1.charAt(i)+ solve(i+1, j, s1, s2);
        int checkj = s2.charAt(j)+ solve(i, j+1, s1, s2);
        return  dp[i][j] = Math.min(checki, checkj);
    }
}