class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 12345;
        int size = m*n;
        long[] pref = new long[size];
        long[] suff = new long[size];

        pref[0] = 1;
        for(int i=1; i<size; i++){
            int r = (i-1)/n;
            int c = (i-1)%n;
            pref[i] = pref[i-1]*grid[r][c]%mod;
        }
        suff[size-1] = 1;
        for(int j=size-2; j>=0; j--){
            int r1 = (j+1)/n;
            int c1 =(j+1)%n;
            suff[j] = suff[j+1]*grid[r1][c1]%mod;
        }
        for(int i=0; i<size; i++){
            int r = i/n;
            int c = i%n;
            grid[r][c] = (int)((pref[i]*suff[i])%mod);
        }
        return grid;
    }
}