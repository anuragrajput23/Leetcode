class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int cnt = 0;
        for(int[] row : mat){
            for(int i=0; i<n; i++){
                if(cnt%2==0){
                    int temp = row[i];
                    int r=i-k;
                    while(r<0) r=r+n;
                    if(row[r]!=temp) return false;
                    cnt++;
                }else{
                    int temp = row[i];
                    int r = (i+k)%n;
                    if(row[r]!=temp) return false;
                    cnt++;
                }
            }
        }
        return true;
    }
}