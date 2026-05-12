class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        return solve(0,0,n,triangle);
    }
    public int solve(int i, int j, int n, List<List<Integer>> tria){
        if(i==n) return (int)1e9;
        if(i==n-1) return tria.get(i).get(j);
        int result = 0;
        int down = tria.get(i).get(j) + solve(i+1,j,n,tria);
        int down_right = tria.get(i).get(j) + solve(i+1,j+1,n,tria);
        return Math.min(down, down_right);
    }
}

//memoisation:
class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        if(n==1) return triangle.get(0).get(0);
        return solve(0,0,n,triangle);
    }
    public int solve(int i, int j, int n, List<List<Integer>> tria){
        if(i==n) return (int)1e9;
        if(i==n-1) return tria.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];
        int result = 0;
        int down = tria.get(i).get(j) + solve(i+1,j,n,tria);
        int down_right = tria.get(i).get(j) + solve(i+1,j+1,n,tria);
        return dp[i][j]= Math.min(down, down_right);
    }
}

//Tabulation:
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        for(int j=0; j<n; j++) dp[n-1][j] = triangle.get(n-1).get(j);
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                int down = triangle.get(i).get(j) + dp[i+1][j];
                dp[i][j] = Math.min(diag, down);
            }
        }
        return dp[0][0];

    }
}

//space optimised
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        int[] front = new int[n];
        for(int i=n-1; i>=0; i--) front[i] = triangle.get(n-1).get(i);
        int[] back = new int[n];
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int diag = triangle.get(i).get(j) + front[j+1];
                int down = triangle.get(i).get(j) + front[j];
                back[j] = Math.min(diag, down);
            }
           front = back.clone();
        }
        return front[0];
    }

}