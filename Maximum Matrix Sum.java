class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int cntNegative = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        long maxAns = 0;
        int mini = Integer.MAX_VALUE;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxAns += Math.abs(matrix[i][j]);

                if(matrix[i][j] < 0){
                    cntNegative++;
                }
                mini = Math.min(mini,Math.abs(matrix[i][j]));
            }
        }
        if(cntNegative%2==0) return maxAns;
        return maxAns - 2*mini;

    }
}