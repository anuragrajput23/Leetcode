class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] row = new long[m];
        long[] col = new long[n];
        long total_sum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                row[i] += (long)grid[i][j];
                col[j] += (long)grid[i][j];
                total_sum += (long)grid[i][j];
            }
        }
        if(total_sum%2!=0) return false;
        long row_sum = 0;
        for(int x=0; x<m; x++){
            row_sum += row[x];
            if(row_sum==total_sum-row_sum){
                return true;
            }
        }
        long col_sum = 0;
        for(int y=0; y<n; y++){
            col_sum += col[y];
            if(col_sum==total_sum - col_sum){
                return true;
            }
        }
        return false;
    }
}