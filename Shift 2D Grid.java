class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                list.add(grid[i][j]);
            }
        }
        k = k%(m*n);
        reverse(0,m*n-k-1,list);
        reverse(m*n-k,m*n-1,list);
        reverse(0,m*n-1,list);
        int idx=0;
        for(int i=0; i<n; i++){
            List<Integer> l = new ArrayList<>();
            for(int j=0; j<m; j++){
                l.add(list.get(idx++));
            }
            ans.add(l);
        }
        return ans;
    }
    public void reverse(int i, int j, List<Integer> list){
        while(i<j){
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
}