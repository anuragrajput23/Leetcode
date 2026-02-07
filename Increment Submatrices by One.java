class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];
        int m = queries.length;
        for(int i=0; i<m; i++){
            int r1 = queries[i][0];
            int c1 = queries[i][1];
            int r2 = queries[i][2];
            int c2 = queries[i][3];

            for(int r=r1; r<=r2; r++){
                result[r][c1] += 1;
                if(c2+1 <= n-1) result[r][c2+1] -= 1;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result[i][j] +=(j-1 >= 0) ? result[i][j-1] : 0;
            }
        }
        return result;
    }
}