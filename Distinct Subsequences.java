class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        return solve(n-1,m-1,s,t);
    }
    public int solve(int i, int j, String s, String t){
        if(j<0) return 1;
        if(i<0) return 0;
        if(s.charAt(i)==t.charAt(j)){
            return solve(i-1,j-1,s,t) + solve(i-1,j,s,t);
        }else{
            return solve(i-1,j,s,t);
        }
    }
}

//memoisation
class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new Integer[n+1][m+1];
        return solve(n-1,m-1,s,t);
    }
    public int solve(int i, int j, String s, String t){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]= solve(i-1,j-1,s,t) + solve(i-1,j,s,t);
        }else{
           return dp[i][j]= solve(i-1,j,s,t);
        }
    }
}