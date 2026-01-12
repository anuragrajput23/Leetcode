class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int m = points.length;
        // int n = points[0].length;
        int ans =0;
        for(int i=1; i<m; i++){
            int x = Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1] - points[i-1][1]);
            ans += Math.max(x,y);
        }
        return ans;
    }
}