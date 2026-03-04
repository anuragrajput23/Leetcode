class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int result = 0;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==1){
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(mat[r][c]==0) continue;
                if(mat[r][c]==1 && col[c]==1 && row[r]==1){
                    result++;
                }
            }
        }
        return result;
    }
}