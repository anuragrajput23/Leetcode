class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        return solve(0,0,n,triangle);
    }
    public int solve(int i, int j, int n, List<List<Integer>> tria){
        if(i==n) return (int)1e9;
        if(i==n-1) return tria.get(i).get(j);
        int result = 0;
        int down = tria.get(i).get(j) + solve(i+1,j,n,tria);
        int down_right = tria.get(i).get(j) + solve(i+1,j+1,n,tria);
        return Math.min(down, down_right);
    }
}