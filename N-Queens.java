class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(".".repeat(n));
        }
        solve(0,list,ans,n);
        return ans;
    }
    public void solve(int col, List<String> list, List<List<String>> ans, int n){
        if(col==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int row=0; row<n; row++){
            if(isValidPosition(col,row,list,n)){
                StringBuilder sb = new StringBuilder(list.get(row));
                sb.setCharAt(col, 'Q');
                list.set(row, sb.toString());

                solve(col + 1, list, ans, n);

                sb.setCharAt(col, '.');
                list.set(row, sb.toString());
            }
        }
    }
    public boolean isValidPosition(int col, int row, List<String> board, int n){
           for (int c = 0; c < col; c++) {
            if (board.get(row).charAt(c) == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int r = row - 1;
        int c = col - 1;

        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check lower-left diagonal
        r = row + 1;
        c = col - 1;

        while (r < n && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') {
                return false;
            }
            r++;
            c--;
        }
        return true;
    }
}