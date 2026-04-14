class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
        int cnt=0;
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1) cnt++;
            }
        ans[i] = cnt;
        }
        return ans;
    }
}