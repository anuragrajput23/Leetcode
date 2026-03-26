class Solution {
    long total=0;
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total+=grid[i][j];
            }
        }

        if(check(grid))return true;

        rev(grid);
        if(check(grid))return true;
        int[][]trans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                trans[i][j]=grid[j][i];
            }
        }

        if(check(trans))return true;
        rev(trans);
        if(check(trans))return true;

        return false;
    }
    public void rev(int[][]grid){
        int i=0,j=grid.length-1;
        while(i<=j){
            int[]temp=grid[i];
            grid[i]=grid[j];
            grid[j]=temp;
            i++;
            j--;
        }
    }
    public boolean check(int[][]grid){
        int n=grid.length;
        int m=grid[0].length;
        HashSet<Long> set=new HashSet<>();
        long top=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                set.add((long)grid[i][j]);
                top+=grid[i][j];
            }
            long bottom=total-top;
            long diff=top-bottom;
            if(diff==0)return true;
            if(diff==(long)grid[0][0] || diff==(long)grid[0][m-1])return true;
            if(i>0 && m>1 && set.contains(diff))return true;
            if(diff==(long)grid[i][0])return true;

        }
        return false;
    }
}