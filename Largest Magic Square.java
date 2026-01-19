class Solution {
    // TC O(n^4) and space = O(m*n);
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //populating prefSumR row-wise
        int[][] prefSumR = new int[m][n];
        for(int i=0; i<m; i++){
            prefSumR[i][0] = grid[i][0];
            for(int j=1; j<n; j++){
                prefSumR[i][j] = grid[i][j] + prefSumR[i][j-1];
            }
        }
        //populating prefSumC column-wise
        int[][] prefSumC = new int[m][n];
        for(int j=0; j<n; j++){
            prefSumC[0][j] = grid[0][j];
            for(int i=1; i<m; i++){
                prefSumC[i][j] = grid[i][j] + prefSumC[i-1][j];
            }
        }
        // checking from min(m,n) because we required largest sq
        for(int check= Math.min(m,n); check>=2; check--){
            for(int i=0; i+check-1 < m; i++){
                for(int j=0; j+check-1 <n; j++){
                    int targetSum = prefSumR[i][j+check-1] - (j>0 ? prefSumR[i][j-1] : 0);
                    boolean allSame = true;
                    for(int r=i+1; r<i+check; r++){
                        int currSum = prefSumR[r][j+check-1] - (j>0 ? prefSumR[r][j-1] : 0);
                        if(currSum!=targetSum){
                            allSame = false;
                            break;
                        }
                    }
                    if(allSame == false) continue;
                    //check all column
                    for(int c=j+1; c<j+check; c++){
                        int currSum = prefSumC[i+check-1][c] - (i>0 ? prefSumC[i-1][c] : 0);
                        if(currSum!=targetSum){
                            allSame = false;
                            break;
                        }
                    }
                    if(allSame == false) continue;
                    //diag checking
                    int diagSum = 0, antiDiagSum  =0;
                    for(int k=0; k<check; k++){
                        diagSum += grid[i+k][j+k];
                        antiDiagSum += grid[i+k][j+check-1-k];
                    }
                    if(diagSum==targetSum && antiDiagSum==targetSum) return check;
                }
            }
        }
        return 1;

    }
}