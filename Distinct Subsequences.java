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

//tabulation
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int j=1; j<m+1; j++) dp[0][j] = 0;
        for(int i=0; i<n+1; i++) dp[i][0] = 1;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}

//space optimisation
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // int[][] dp = new int[n+1][m+1];
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        prev[0]=1;
        curr[0]=1;


        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[m];
    }
}

//1d array optimisation
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        Arrays.fill(prev,0);
        prev[0]=1;
        for(int i=1; i<n+1; i++){
            for(int j=m; j>=1; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
            }
        }
        return prev[m];
    }
}

//memoised
class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new Integer[n+1][m+1];
        return solve(n-1,m-1,word1,word2);
    }
    public int solve(int i, int j,String s1,String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 0+solve(i-1,j-1,s1,s2);
        }else{
            return dp[i][j]= Math.min(
                1+solve(i-1,j,s1,s2),
                Math.min(1+solve(i-1,j-1,s1,s2),
                1+solve(i,j-1,s1,s2))
            );
        }
    }
}