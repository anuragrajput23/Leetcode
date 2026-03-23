class Solution {
    int mod=1_000_000_007;
    Long[][][]dp;
    public int maxProductPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Long[n][m][2];
        long[] ans=solve(grid,0,0,n,m);
        return ans[0]<0?-1:(int)(ans[0]%mod);
    }
    public long[] solve(int[][]grid,int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return new long[]{grid[i][j],grid[i][j]};
        }
        if(i>=n || j>=m){
            return new long[]{Long.MIN_VALUE,Long.MAX_VALUE};
        }
        if(dp[i][j][0]!=null){
            return new long[]{dp[i][j][0],dp[i][j][1]};
        }
        long maxi=Long.MIN_VALUE;
        long mini=Long.MAX_VALUE;

        long[]down=solve(grid,i+1,j,n,m);
        if(down[0]!=Long.MIN_VALUE){
            long a=grid[i][j]*down[0];
            long b=grid[i][j]*down[1];
            maxi=Math.max(maxi,Math.max(a,b));
            mini=Math.min(mini,Math.min(a,b));
        }

        long[]right=solve(grid,i,j+1,n,m);
        if(right[0]!=Long.MIN_VALUE){
            long a=grid[i][j]*right[0];
            long b=grid[i][j]*right[1];
            maxi=Math.max(maxi,Math.max(a,b));
            mini=Math.min(mini,Math.min(a,b));
        }
        dp[i][j][0]=maxi;
        dp[i][j][1]=mini;
        return  new long[]{maxi,mini};

    }
}