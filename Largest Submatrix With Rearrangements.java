class Solution {
    public int largestSubmatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][]arr=new int[n][m];
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                if(mat[i][j]==1){
                    sum++;
                }else{
                    sum=0;
                }
                arr[i][j]=sum;
            }
        }
        int maxi=0;
        for(int[]a:arr){
            Arrays.sort(a);
            int base=1;
            for(int i=a.length-1;i>=0;i--){
                int height=a[i];
                maxi=Math.max(maxi,height*base);
                base++;
                if(height==0){
                    base=1;
                }
            }
        }
        return maxi;
    }
}